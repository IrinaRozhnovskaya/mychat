package com.message.domain;

import java.util.Date;
import java.util.UUID;

public class Message implements Comparable<Message> {

    private UUID id;
    private String from;
    private String body;
    private Date createdAt;

    public Message(final UUID id, final String from, final String body, final Date createdAt) {
        this.id = id;
        this.from = from;
        this.body = body;
        this.createdAt = createdAt;
    }

    public Message(final String from, final String body) {
        this(UUID.randomUUID(),from, body, new Date());
    }

    public String getFrom() {
        return from;
    }

    public String getBody() {return body;}

    public Date getCreatedAt() {
        return createdAt;
    }

    public UUID getId() {
        return id;
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
