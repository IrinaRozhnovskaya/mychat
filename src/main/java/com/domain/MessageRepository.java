package com.domain;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Named
@ApplicationScoped
public class MessageRepository {

    private Map<UUID, Message> messages;

    @PostConstruct
    public void init() {
        messages = new ConcurrentHashMap<>();
        messages.put(UUID.randomUUID(), new Message("ololo", "trololo", new Date()));
    }

    public List<Message> findAllOrderByCreatedAt() {
        final TreeSet<Message> result = new TreeSet<>();
        final List<Message> all = Collections.unmodifiableList(new ArrayList<>(messages.values()));
        result.addAll(all);
        return Collections.unmodifiableList(new ArrayList<>(result));
    }
}
