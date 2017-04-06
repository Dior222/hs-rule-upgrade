package com.hansight.tool.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * JsonUtil
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 16/9/7
 */
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJsonStr(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("Error parsing object to json string ! {}", e);
        }
        return null;
    }

    public static <T> T parseObject(String jsonStr, Class<T> classType) throws IOException {
        return objectMapper.readValue(jsonStr, classType);
    }
}
