package com.hansight.tool.model;

/**
 * InnerEvent
 *
 * @author chenkui
 * @version 1.0
 * @date 2016/11/25
 */
public class InnerEvent {
    boolean enabled;
    String name;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InnerEvent{" +
                "enable=" + enabled +
                ", name='" + name + '\'' +
                '}';
    }
}
