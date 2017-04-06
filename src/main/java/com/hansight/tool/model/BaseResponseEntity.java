package com.hansight.tool.model;

import java.util.List;

/**
 * BaseResponseEntity
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 16/11/28
 */
public class BaseResponseEntity<T> {
    private int statusCode = 0;
    private List<T> messages;
    private ResponseData data;

    public ResponseData<T> getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    public List<? extends Object> getMessages() {
        return messages;
    }

    public void setMessages(List<T> messages) {
        this.messages = messages;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
