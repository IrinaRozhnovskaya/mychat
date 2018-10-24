package com.message;

import javax.inject.Inject;
import java.util.Set;

public class MessageService {

    @Inject
    MessageRepository messageRepository;

    public boolean isDataValid(final String from, final String body) {
        return null != from && null != body && !"".equals(from.trim()) && !"".equals(body);
    }

    public void save(final Message message) {
        messageRepository.save(message);
    }

    public Set<Message> tailMessages() {
        return messageRepository.findAllOrderByCreatedAt();
    }
}
