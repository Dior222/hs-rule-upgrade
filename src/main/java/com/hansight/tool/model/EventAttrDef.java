package com.hansight.tool.model;

/**
 * EventAttrDef
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class EventAttrDef {
    private String id;
    private String as;
    private String attrField;
    private String attrName;
    private String attrType;
    private Event event;

    public String parseMe(){
        return as+"."+attrField;
    }

    public String parseMe(int index) {
        return as + "[" + index + "]." + attrField;
    }

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public String getAttrField() {
        return attrField;
    }

    public void setAttrField(String attrField) {
        this.attrField = attrField;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventAttrDef{" +
                "as='" + as + '\'' +
                ", id='" + id + '\'' +
                ", attrField='" + attrField + '\'' +
                ", attrName='" + attrName + '\'' +
                ", attrType='" + attrType + '\'' +
                '}';
    }
}
