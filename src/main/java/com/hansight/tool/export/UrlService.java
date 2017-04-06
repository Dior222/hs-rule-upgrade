package com.hansight.tool.export;

import org.springframework.stereotype.Component;

/**
 * UrlService
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 17/4/5
 */
@Component
public class UrlService {

    public String getRuleTypeUrl(String server, int port) {
        return "http://" + server + ":" + port + "/api/cep/rule-types";
    }

    public String getRulesUrl(String server, int port) {
        return "http://"+server+":" + port + "/api/cep/rules";
    }

    public String getExportUrl(String server, int port, String ids) {
        return "http://"+server+":" + port + "/api/cep/rules-importexport?ids=" + ids;
    }

    public String getImportUrl(String server, String ruleType) {
        return "http://" + server + "/api/cep/rules-importexport?ruleType=" + ruleType;
    }

}
