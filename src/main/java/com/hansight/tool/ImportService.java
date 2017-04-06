package com.hansight.tool;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.hansight.tool.config.Configuration;
import com.hansight.tool.export.UrlService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * ImportService
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 17/4/6
 */
@Component
public class ImportService {

    private static final Logger logger = LoggerFactory.getLogger(ImportService.class);

    @Autowired
    private Configuration configuration;

    @Autowired
    private UrlService urlService;

    private CloseableHttpClient client;

    private String server;

    private String rulesLocation;

    private static Pattern filenamePattern = Pattern.compile("\\d{5,}");

    @PostConstruct
    public void init() {
        this.server = configuration.getDstServer() + ":" + configuration.getDstPort();
        this.rulesLocation = configuration.getExportLocation();
        this.client = HttpClients.createDefault();
    }

    @PreDestroy
    public void close() throws IOException {
        client.close();
    }

    public void upload() {

        File rulesDir = new File(this.rulesLocation);
        if (!rulesDir.exists()) {
            logger.warn("导入的规则目录不存在!");
            return;
        }

        File[] listFiles = rulesDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return filenamePattern.matcher(pathname.getName()).matches();
            }
        });

        if (listFiles.length <= 0) {
            logger.warn("没有规则文件!");
        }

        logger.info("==开始导入文件夹下的规则文件。。。==");
        CloseableHttpResponse resp = null;
        try {
            for (File file : listFiles) {
                try {
                    importFile(file, resp);
                    TimeUnit.SECONDS.sleep(1);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            if (resp != null) {
                try {
                    resp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("Done.");
    }

    private void importFile(File file, CloseableHttpResponse resp) throws IOException {
        String content = readContent(file);
        String ruleType = file.getName();
        String url = urlService.getImportUrl(this.server, ruleType);
        logger.info("import ruleType : {}, url : {}", ruleType, url);
        HttpPost post = new HttpPost(url);
        StringEntity entity = new StringEntity(content);
        post.setEntity(entity);
        resp = client.execute(post);
        String msg = EntityUtils.toString(resp.getEntity());
        logger.info("result : {}", msg);
    }

    private String readContent(File file) throws IOException {
        return String.join("\n", Files.readLines(file, Charsets.UTF_8));
    }
}
