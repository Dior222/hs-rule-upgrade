package com.hansight.tool.export;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.io.Files;
import com.hansight.tool.config.Configuration;
import com.hansight.tool.model.BaseResponseEntity;
import com.hansight.tool.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ExportService
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 17/4/5
 */
@Component
public class ExportService {

    @Autowired
    private Configuration configuration;

    @Autowired
    private UrlService urlService;

    private CloseableHttpClient client;

    public ExportService() {
        client = HttpClients.createDefault();
    }

    @PostConstruct
    public void init() {
        File loc = new File(configuration.getExportLocation());
        if (!loc.exists()) {
            loc.mkdirs();
        }
    }

    @PreDestroy
    public void close() throws IOException {
        client.close();
    }

    public List<Map> listAll() {
        String url = urlService.getRulesUrl(configuration.getSrcServer(), configuration.getSrcPort());
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            BaseResponseEntity<Map> rules = JsonUtil.parseObject(content, BaseResponseEntity.class);

            return rules.getData().getList();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static final String PART_DELIMETER = "\n-------------------------------------\n";

    public void export(String ruleType, Map<String, List<Integer>> rules) {
        CloseableHttpResponse response = null;
        try {
            if (!rules.containsKey(ruleType)) {
                return;
            }
            String ruleIds = Joiner.on(",").join(rules.get(ruleType));
            String exportUrl = urlService.getExportUrl(configuration.getSrcServer(), configuration.getSrcPort(), ruleIds);
            HttpGet httpGet = new HttpGet(exportUrl);
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            String[] arr = content.split(PART_DELIMETER);
            File dstFile = new File("rules/" + ruleType);
            if (!dstFile.exists()) {
                dstFile.createNewFile();
            }
            Files.write(String.join(PART_DELIMETER, "", "", arr[2]), dstFile, Charsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExportService exportService = new ExportService();
        List<Map> rules = exportService.listAll();
        for (Map rule : rules) {
            System.out.println(rule.get("id") + "-->" + rule.get("type"));
        }
    }
}
