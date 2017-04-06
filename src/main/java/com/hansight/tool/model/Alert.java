package com.hansight.tool.model;

import java.util.List;

/**
 * Alert
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class Alert {
    boolean enabled;
    List<String> knowledge;
    List<String> recipients;
    List<String> assets;

    /**
     * 2016/12/13新增告警字段
     */
    private int focus;
    private String alarmContent;
    private String alarmLevel;
    private String alarmType;
    private String alarmStage;

    /**
     * 2017/01/11新增字段,用于做告警通知用
     */
    private boolean emailEnabled;
    private boolean smsEnabled;
    private List<String> phoneNumbers;

    /**
     *  2017/03/10 新增字段
     */
    private String ruleType;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getAssets() {
        return assets;
    }

    public void setAssets(List<String> assets) {
        this.assets = assets;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public List<String> getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(List<String> knowledge) {
        this.knowledge = knowledge;
    }

    public String getAlarmContent() {
        return alarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public String getAlarmStage() {
        return alarmStage;
    }

    public void setAlarmStage(String alarmStage) {
        this.alarmStage = alarmStage;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public boolean isEmailEnabled() {
        return emailEnabled;
    }

    public void setEmailEnabled(boolean emailEnabled) {
        this.emailEnabled = emailEnabled;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public boolean isSmsEnabled() {
        return smsEnabled;
    }

    public void setSmsEnabled(boolean smsEnabled) {
        this.smsEnabled = smsEnabled;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alarmContent='" + alarmContent + '\'' +
                ", enabled=" + enabled +
                ", knowledge=" + knowledge +
                ", recipients=" + recipients +
                ", assets=" + assets +
                ", focus=" + focus +
                ", alarmLevel='" + alarmLevel + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", alarmStage='" + alarmStage + '\'' +
                ", emailEnabled=" + emailEnabled +
                ", smsEnabled=" + smsEnabled +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
