package com.hansight.tool.model;

import java.util.List;

/**
 * ResponseData
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 16/11/28
 */
public class ResponseData<T> {
    private int total = -1;
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
