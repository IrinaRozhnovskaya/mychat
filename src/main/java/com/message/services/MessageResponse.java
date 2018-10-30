package com.message.services;

public class MessageResponse {

    final String from, body, when;

    public MessageResponse(String from, String body, String when) {
        this.from = from;
        this.body = body;
        this.when = when;
    }

    public String getBody() {
        return body;
    }

    public String getWhen() {
        return when;
    }

    public String getFrom() {
        return from;
    }
}
