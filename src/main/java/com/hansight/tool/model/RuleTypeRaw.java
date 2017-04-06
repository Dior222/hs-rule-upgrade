package com.hansight.tool.model;

import java.io.Serializable;

/**
 * RuleTypeRaw
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 16/12/14
 */
public class RuleTypeRaw implements Serializable {
    protected String name;
//    @JsonSerialize(using = ToStringSerializer.class)
    protected String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "RuleTypeRaw{" +
                "name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
