package com.hansight.tool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * RuleType
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 16/12/14
 */
public class RuleType extends RuleTypeRaw implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private int id;
    @JsonIgnore
    private String idPath;
    @JsonIgnore
    private String namePath;

//    @JsonProperty
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    public String getNamePath() {
        return namePath;
    }

    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }

    @Override
    public String toString() {
        return "RuleType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", idPath='" + idPath + '\'' +
                ", namePath='" + namePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RuleType ruleType = (RuleType) o;

        if (id != ruleType.id) return false;
        if (idPath != null ? !idPath.equals(ruleType.idPath) : ruleType.idPath != null) return false;
        return namePath != null ? namePath.equals(ruleType.namePath) : ruleType.namePath == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idPath != null ? idPath.hashCode() : 0);
        result = 31 * result + (namePath != null ? namePath.hashCode() : 0);
        return result;
    }
}
