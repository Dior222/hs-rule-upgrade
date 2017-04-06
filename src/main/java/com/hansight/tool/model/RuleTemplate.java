package com.hansight.tool.model;

/**
 * RuleTemplate
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class RuleTemplate {
    int id;
    String name;
    String desc;
    String type;
    String patternOperator;
    boolean hasContext;
    boolean hasSelect;
    boolean hasFilter;
    boolean hasWindow;
    boolean hasGroupBy;
    boolean hasHaving;
    HavingTpl having;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPatternOperator() {
        return patternOperator;
    }

    public void setPatternOperator(String patternOperator) {
        this.patternOperator = patternOperator;
    }

    public boolean isHasContext() {
        return hasContext;
    }

    public void setHasContext(boolean hasContext) {
        this.hasContext = hasContext;
    }

    public boolean isHasFilter() {
        return hasFilter;
    }

    public void setHasFilter(boolean hasFilter) {
        this.hasFilter = hasFilter;
    }

    public boolean isHasWindow() {
        return hasWindow;
    }

    public void setHasWindow(boolean hasWindow) {
        this.hasWindow = hasWindow;
    }

    public boolean isHasGroupBy() {
        return hasGroupBy;
    }

    public void setHasGroupBy(boolean hasGroupBy) {
        this.hasGroupBy = hasGroupBy;
    }

    public boolean isHasHaving() {
        return hasHaving;
    }

    public void setHasHaving(boolean hasHaving) {
        this.hasHaving = hasHaving;
    }

    public HavingTpl getHaving() {
        return having;
    }

    public void setHaving(HavingTpl having) {
        this.having = having;
    }

    public boolean isHasSelect() {
        return hasSelect;
    }

    public void setHasSelect(boolean hasSelect) {
        this.hasSelect = hasSelect;
    }

    @Override
    public String toString() {
        return "RuleTemplate{" +
                "desc='" + desc + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", patternOperator='" + patternOperator + '\'' +
                ", hasContext=" + hasContext +
                ", hasFilter=" + hasFilter +
                ", hasWindow=" + hasWindow +
                ", hasGroupBy=" + hasGroupBy +
                ", hasHaving=" + hasHaving +
                ", having=" + having +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RuleTemplate that = (RuleTemplate) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
