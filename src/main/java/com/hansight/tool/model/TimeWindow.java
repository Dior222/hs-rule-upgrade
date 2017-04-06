package com.hansight.tool.model;

/**
 * TimeWindow
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class TimeWindow {
    String type;
    int value;
    String unit;
    EventAttrDef event;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public EventAttrDef getEvent() {
        return event;
    }

    public void setEvent(EventAttrDef event) {
        this.event = event;
    }

    @Override
    public String toString() {
        if (event == null) {
            return ".win:" + type + "(" + value + " " + unit + ")";
        }
        /*if (event.getAs() == null || event.getAs().isEmpty()) {
            return ".win:" + type + "(" + value + " " + unit + ")";
        }*/
        return ".win:" + type + "(" + event.getAttrField() + "," + value + " " + unit + ")";
    }

    public String toRepeatString() {
        StringBuilder sb = new StringBuilder(".win:");
        sb.append(type).append("(").append(event.getAs()).append("[0].")
                .append(event.getAttrField()).append(",")
                .append(value).append(" ").append(unit).append(")");
        return sb.toString();
    }

    public String toStringWithAs() {
        if (event == null) {
            return ".win:" + type + "(" + value + " " + unit + ")";
        }
        /*if (event.getAs() == null || event.getAs().isEmpty()) {
            return ".win:" + type + "(" + value + " " + unit + ")";
        }*/
        return ".win:" + type + "(" + event.getAs() + "." + event.getAttrField() + "," + value + " " + unit + ")";
    }
}
