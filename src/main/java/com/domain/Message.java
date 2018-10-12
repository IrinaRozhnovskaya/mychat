package com.domain;

import java.util.Comparator;
import java.util.Date;

public class Message implements Comparable<Message> {

    private String to;
    private String body;
    private Date createdAt;

    public Message() { }

    public Message(String to, String body, Date createdAt) {
        this.to = to;
        this.body = body;
        this.createdAt = createdAt;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(final Message o) {
        return this.createdAt.compareTo(o.getCreatedAt());
    }
}
