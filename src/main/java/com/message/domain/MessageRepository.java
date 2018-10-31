package com.message.domain;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Collections.unmodifiableSet;
import static java.util.Collections.unmodifiableSortedSet;

@Singleton
public class MessageRepository {

    private Map<String, List<Message>> db;

    @PostConstruct
    public void init() {
        db = new ConcurrentHashMap<>();
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

    public Set<Message> findAllOrderByCreatedAtDesc() {
        final ArrayList<Message> result = new ArrayList<>();
        for (List<Message> messages : db.values()) {
            for (Message message : messages) {
                result.add(message);
            }
        }
        return unmodifiableSortedSet(new TreeSet<>(result));
    }
}
