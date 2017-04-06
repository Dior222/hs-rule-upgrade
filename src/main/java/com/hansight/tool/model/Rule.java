package com.hansight.tool.model;

import com.google.common.base.Joiner;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rule
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class Rule implements Serializable {
    int id;
    String name;
    String desc;
    int status;
    int templateId;
    String type;
    boolean hasContext;
    int contextId;

    List<EventDef> events;
    RepeatDef patternRepeat;
    List<SelectDef> selects;
    TimeWindow window;
    List<EventAttrDef> groupBy;
    String where;
    InnerEvent innerEvent;
    Map<String, Object> having;
    Alert alert;

    int editable = 1;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getHaving() {
        return having;
    }

    public void setHaving(Map<String, Object> having) {
        this.having = having;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public int getContextId() {
        return contextId;
    }

    public void setContextId(int contextId) {
        this.contextId = contextId;
    }


    public List<EventDef> getEvents() {
        return events;
    }

    public void setEvents(List<EventDef> events) {
        this.events = events;
    }

    public List<SelectDef> getSelects() {
        return selects;
    }

    public void setSelects(List<SelectDef> selects) {
        this.selects = selects;
    }

    public String buildSelectJoins(){
        return Joiner.on(", ").join(selects);
    }

    public TimeWindow getWindow() {
        return window;
    }

    public void setWindow(TimeWindow window) {
        this.window = window;
    }

    public String buildGroupByJoins(){
        if (groupBy == null || groupBy.isEmpty()) {
            return "";
        }
        return Joiner.on(", ").join(groupBy);
    }
    public List<EventAttrDef> getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(List<EventAttrDef> groupBy) {
        this.groupBy = groupBy;
    }

    public RepeatDef getPatternRepeat() {
        return patternRepeat;
    }

    public void setPatternRepeat(RepeatDef patternRepeat) {
        this.patternRepeat = patternRepeat;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public boolean isHasContext() {
        return hasContext;
    }

    public void setHasContext(boolean hasContext) {
        this.hasContext = hasContext;
    }

    public InnerEvent getInnerEvent() {
        return innerEvent;
    }

    public void setInnerEvent(InnerEvent innerEvent) {
        this.innerEvent = innerEvent;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getEditable() {
        return editable;
    }

    public void setEditable(int editable) {
        this.editable = editable;
    }

    public Map<String, String> buildTpl(){
        Map<String,String> data = new HashMap<>();
        if (having == null) {
            return data;
        }
        having.keySet().forEach(e->{
            Object value = having.get(e);;
            if(value instanceof JsonObject){
                data.put(name, value.toString());
//                data.put(name, value.getAsJsonObject().get("as").getAsString() + "." + value.getAsJsonObject().get("name").getAsString());
            }
            else {
                data.put(name, value.toString());
            }
        });
        return data;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "alert=" + alert +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", status=" + status +
                ", templateId=" + templateId +
                ", type='" + type + '\'' +
                ", hasContext=" + hasContext +
                ", contextId=" + contextId +
                ", events=" + events +
                ", patternRepeat=" + patternRepeat +
                ", selects=" + selects +
                ", window=" + window +
                ", groupBy=" + groupBy +
                ", innerEvent=" + innerEvent +
                ", having=" + having +
                ", editable=" + editable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rule rule = (Rule) o;

        if (id != rule.id) return false;
        if (name != null ? !name.equals(rule.name) : rule.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
