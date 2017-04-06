package com.hansight.tool.export;

import com.hansight.tool.config.Configuration;
import com.hansight.tool.model.BaseResponseEntity;
import com.hansight.tool.model.RuleType;
import com.hansight.tool.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.*;

/**
 * EventTypeService
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 17/4/5
 */
@Component
public class EventTypeService {

    @Autowired
    private Configuration configuration;

    @Autowired
    private UrlService urlService;

    private CloseableHttpClient client;

    public EventTypeService() {
        client = HttpClients.createDefault();
    }

    @PreDestroy
    public void close() throws IOException {
        client.close();
    }

    public Set<RuleType> getEventTypes() {
        String url = urlService.getRuleTypeUrl(configuration.getSrcServer(), configuration.getSrcPort());
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            BaseResponseEntity<Map> ruleTypes = JsonUtil.parseObject(content, BaseResponseEntity.class);

            List<RuleType> ruleTypeList = new ArrayList<>();
            for (Map map : ruleTypes.getData().getList()) {
                ruleTypeList.add(parseRuleType(map));
            }
            Set<RuleType> leafTypes = getLeafTypes(ruleTypeList);
            return leafTypes;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private RuleType parseRuleType(Map map) {
        RuleType ruleType = new RuleType();
        ruleType.setId(Integer.parseInt(parse(map, "id")));
        ruleType.setIdPath(parse(map, "idPath"));
        ruleType.setNamePath(parse(map, "namePath"));
        ruleType.setParentId(parse(map, "parentId"));
        ruleType.setName(parse(map, "name"));
        return ruleType;
    }

    private String parse(Map map, String key) {
        if (map.containsKey(key)) {
            return map.get(key).toString();
        }
        return null;
    }

    private Set<RuleType> getLeafTypes(List<RuleType> ruleTypes) {
        Set<RuleType> leafTypes = new HashSet<>();
        Map<String, Map<String, RuleType>> ruleTypeMap = new HashMap<>();
        for (RuleType ruleType : ruleTypes) {
            if (!ruleTypeMap.containsKey(ruleType.getParentId())) {
                ruleTypeMap.put(ruleType.getParentId(), new HashMap<>());
            }
            Map<String, RuleType> map = ruleTypeMap.get(ruleType.getParentId());
            map.put(ruleType.getId() + "", ruleType);
            ruleTypeMap.put(ruleType.getParentId(), map);
        }
        for (RuleType ruleType : ruleTypes) {
            if (ruleType.getId() != 1  /*&&!"1".equals(ruleType.getParentId())*/) {
                if (!ruleTypeMap.containsKey(ruleType.getId() + "")) {
                    leafTypes.add(ruleType);
                }
            }
        }
        return leafTypes;
    }

    private boolean hasNoChildren(RuleType ruleType, Map<String, Map<String, RuleType>> ruleTypeMap) {
        return !ruleTypeMap.containsKey(ruleType.getId() + "");
    }

    public static void main(String[] args) throws IOException {
        EventTypeService eventTypeService = new EventTypeService();
        eventTypeService.getEventTypes();
        eventTypeService.close();
    }

}
