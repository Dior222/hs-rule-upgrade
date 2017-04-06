package com.hansight.tool;

import com.hansight.tool.export.EventTypeService;
import com.hansight.tool.export.ExportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * MigrationService
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 17/4/5
 */
@Component
public class MigrationService {

    private static final Logger logger = LoggerFactory.getLogger(MigrationService.class);

    @Autowired
    private EventTypeService eventTypeService;

    @Autowired
    private ExportService exportService;

    @Autowired
    private ImportService importService;

    public void work() {

        /**
         * 1. export
         */
        try {
            List<Map> allRules = exportService.listAll();
            Map<String, List<Integer>> ruleTypeMap = new HashMap<>();
            for (Map map : allRules) {
                Integer ruleId = Integer.parseInt(map.get("id").toString());
                String ruleType = map.get("type").toString();
                if (!ruleTypeMap.containsKey(ruleType)) {
                    ruleTypeMap.put(ruleType, new ArrayList<>());
                }
                List<Integer> ruleTypes = ruleTypeMap.get(ruleType);
                ruleTypes.add(ruleId);
                ruleTypeMap.put(ruleType, ruleTypes);
            }

            logger.info("=========== rule type map ===========");
            for (String ruleType : ruleTypeMap.keySet()) {
                logger.info("ruletype:{} => {}", ruleType, ruleTypeMap.get(ruleType));
            }

            logger.info("\n==> try down load ruletype...");
            for (String type : ruleTypeMap.keySet()) {
                exportService.export(type, ruleTypeMap);
            }
        } catch (Exception e) {
            logger.error("Error downloading rules...{}", e);
        }

        //sleep for 5 seconds...
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 2. import
         */
        try {
            importService.upload();
        } catch (Exception e) {
            logger.error("Error importing rules...{}", e);
        }

    }

    @PreDestroy
    public void close() {

        logger.info("==> shutting down services...");

        //close event type service
        try {
            eventTypeService.close();
            logger.info("event type service closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //close export service
        try {
            exportService.close();
            logger.info("export service closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //close import service
        try {
            importService.close();
            logger.info("import service closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
