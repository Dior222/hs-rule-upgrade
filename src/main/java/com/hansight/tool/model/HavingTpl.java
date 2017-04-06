package com.hansight.tool.model;

import java.util.regex.Pattern;

/**
 * HavingTpl
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class HavingTpl {
    Pattern pattern = Pattern.compile("\\{\\{(n\\d):(select|select2|number):(\\S+)\\}\\}");//.matcher("count(distinct({{n1:select2:fields}})) {{n2:select:[>,<,>=,<=,=,!=]}} {{n3:number:10}}");

    String eplTpl;
    String descTpl;

    public String getEplTpl() {
//        return eplTpl.replaceAll("\\n", " ");
        return eplTpl;
    }

    public void setEplTpl(String eplTpl) {
        this.eplTpl = eplTpl;
    }

    public String getDescTpl() {
        return descTpl;
    }

    public void setDescTpl(String descTpl) {
        this.descTpl = descTpl;
    }
}
