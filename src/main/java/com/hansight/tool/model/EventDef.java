package com.hansight.tool.model;

/**
 * EventDef
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class EventDef {
    private Event event;
    private String as;
    //TODO 这里先将filter定义成string类型
    private String filter;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "EventDef{" +
                "as='" + as + '\'' +
                ", event=" + event +
                ", filter='" + filter + '\'' +
                '}';
    }
}
