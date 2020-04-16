package com.sl.web.util;

import com.sl.web.constant.MessageType;

/**
 * Created by Achi on 4/16/2020.
 */
public class MessageUtil {
    private MessageType messageType;
    private String message;

    public MessageUtil( MessageType messageType,String message) {
        this.messageType = messageType;
        this.message = message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
