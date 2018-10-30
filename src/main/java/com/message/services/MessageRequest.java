package com.message.services;

import java.util.Map;

public class MessageRequest {
    final String messageBody;
    final Map<String, Object> metadata;

    public MessageRequest(String messageBody, Map<String, Object> metadata) {
        this.messageBody = messageBody;
        this.metadata = metadata;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }
}
