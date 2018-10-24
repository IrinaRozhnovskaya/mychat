package com.message;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Collections.unmodifiableSet;

@Singleton
public class MessageRepository {

    private Map<UUID, Message> messages;

    @PostConstruct
    public void init() {
        messages = new ConcurrentHashMap<>();
    }

    public Set<Message> findAllOrderByCreatedAt() {
        return unmodifiableSet(
                new TreeSet<>(messages.values()));
    }

    public void save(final Message message) {
        messages.put(UUID.randomUUID(), message);
    }
}
