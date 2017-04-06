package com.hansight.tool.model;

import org.apache.commons.lang3.StringUtils;

/**
 * SelectDef
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class SelectDef {
    EventAttrDef event;
    boolean hasAlias;
    boolean hasFn;
    String alias;
    String fn;
//    String type;

    /***
     *  string[0]: 原始字段拼接，例如：A.event_name、first(A.occur_time)
     *  string[1]: 重命名信息， 例如：event_name、start_time，这种不包含A.、B.
     * @return
     */
    public String[] parseMe(){
        String[] aliasAndFiled = new String[2];
        StringBuilder sb = new StringBuilder();

        if(hasFn){
            sb.append(fn);
            sb.append("(");
        }
        sb.append(event.parseMe());
        if(hasFn){
            sb.append(")");
        }
        aliasAndFiled[0] = sb.toString();

        if(hasAlias) {
            aliasAndFiled[1] = alias;
        }
        else {
            aliasAndFiled[1] = event.getAttrField();
        }
        if(StringUtils.isEmpty(aliasAndFiled[0]) || StringUtils.isEmpty(aliasAndFiled[1])){
            return null;
        }
        return aliasAndFiled;
    }

    /***
     *  string[0]: 原始字段拼接，例如：A.event_name、first(A.occur_time)
     *  string[1]: 重命名信息， 例如：event_name、start_time，这种不包含A.、B.
     * @return
     */
    public String[] parseMe(int index){
        String[] aliasAndFiled = new String[2];
        StringBuilder sb = new StringBuilder();

        if(hasFn){
            sb.append(fn);
            sb.append("(");
        }
        sb.append(event.parseMe(index));
        if(hasFn){
            sb.append(")");
        }
        aliasAndFiled[0] = sb.toString();

        if(hasAlias) {
            aliasAndFiled[1] = alias;
        }
        else {
            aliasAndFiled[1] = event.getAttrField();
        }
        if(StringUtils.isEmpty(aliasAndFiled[0]) || StringUtils.isEmpty(aliasAndFiled[1])){
            return null;
        }
        return aliasAndFiled;
    }

    public EventAttrDef getEvent() {
        return event;
    }

    public void setEvent(EventAttrDef event) {
        this.event = event;
    }

    public boolean isHasAlias() {
        return hasAlias;
    }

    public void setHasAlias(boolean hasAlias) {
        this.hasAlias = hasAlias;
    }

    public boolean isHasFn() {
        return hasFn;
    }

    public void setHasFn(boolean hsFn) {
        this.hasFn = hsFn;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    @Override
    public String toString() {
        return "SelectDef{" +
                "alias='" + alias + '\'' +
                ", event=" + event +
                ", hasAlias=" + hasAlias +
                ", hasFn=" + hasFn +
                ", fn='" + fn + '\'' +
                '}';
    }
}
