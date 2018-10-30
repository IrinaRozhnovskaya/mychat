package com.message.services;

import com.message.domain.Message;
import com.message.domain.MessageRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class MessageService implements Serializable {

    @Inject
    MessageRepository messageRepository;

    public void sendMessage(final MessageRequest sendMessageRequest) {

        if (sendMessageRequest == null) return;

        final String messageBody = sendMessageRequest.messageBody;

        if (messageBody == null) return;
        if (messageBody.trim().equals("")) return;

        final String identifier = sendMessageRequest.getMetadata().values().toString();

        messageRepository.save(new Message(identifier, messageBody));
    }

    public Set<List<Message>> findMessagesInDescendOrder() {
        return messageRepository.findAllOrderByCreatedAtDesc();
    }
}
