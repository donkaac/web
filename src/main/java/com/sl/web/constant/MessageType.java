package com.sl.web.constant;

/**
 * Created by Achi on 4/16/2020.
 */
public enum MessageType {
    INFO("info"), SUCCESS("success"), WARNING("warning"), DANGER("danger");

    private String value;

    MessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
