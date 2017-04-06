package com.hansight.tool.model;

/**
 * Event
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 16/12/7
 */
public class Event {
    private String id;
    private String name;
    private String typeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return name;
    }
}
