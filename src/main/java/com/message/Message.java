package com.message;

import java.util.Date;

public class Message implements Comparable<Message> {

    private String from;
    private String body;
    private Date createdAt;

    public Message(final String from, final String body, final Date createdAt) {
        this.from = from;
        this.body = body;
        this.createdAt = createdAt;
    }

    public Message(final String from, final String body) {
        this(from, body, new Date());
    }

    public String getFrom() {
        return from;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public int compareTo(final Message other) {
        return -this.createdAt.compareTo(other.getCreatedAt());
    }

    @Override
    public String toString() {
        return "Message{" +
                ", from='" + from + '\'' +
                ", body='" + body + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
