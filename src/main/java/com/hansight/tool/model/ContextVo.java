package com.hansight.tool.model;

import java.util.List;

/**
 * ContextVo
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 16/11/29
 */
public class ContextVo {
    private int id;
    private String name;
    private String desc;
    private List<EventAttrDef> partitionBy;
    private List<EventDef> events;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<EventDef> getEvents() {
        return events;
    }

    public void setEvents(List<EventDef> events) {
        this.events = events;
    }

    public List<EventAttrDef> getPartitionBy() {
        return partitionBy;
    }

    public void setPartitionBy(List<EventAttrDef> partitionBy) {
        this.partitionBy = partitionBy;
    }

    @Override
    public String toString() {
        return "ContextVo{" +
                "desc='" + desc + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", partitionBy=" + partitionBy +
                ", events=" + events +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContextVo contextVo = (ContextVo) o;

        if (id != contextVo.id) return false;
        if (name != null ? !name.equals(contextVo.name) : contextVo.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
