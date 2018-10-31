package com.message.services;

public class MessageRequest {

    final String sender, messageBody;

    public static MessageRequest of(String sender, String messageBody) {
        return new MessageRequest(messageBody, sender);
    }

    MessageRequest(String messageBody, String sender) {
        this.messageBody = messageBody;
        this.sender = sender;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public String getSender() {
        return sender;
    }
}
