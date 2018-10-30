package com.message.domain;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Collections.unmodifiableSet;

@Singleton
public class MessageRepository implements Serializable {

    private Map<String, List<Message>> db;

    @PostConstruct
    public void init() {
        db = new ConcurrentHashMap<>();
    }

    public Set<List<Message>> findAllOrderByCreatedAtDesc() {
        return unmodifiableSet(
                new TreeSet<>(db.values()));
    }

    public void save(final Message message) {
        final String key = message.getFrom();
        final List<Message> maybeMessages = db.get(key);
        if (maybeMessages == null) {
            db.put(key, new ArrayList<Message>());
        }
        final List<Message> messages = db.get(key);
        messages.add(message);
        db.put(key, messages);
    }
}
