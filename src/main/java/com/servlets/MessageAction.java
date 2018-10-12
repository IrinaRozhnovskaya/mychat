package com.servlets;

import com.domain.Message;
import com.domain.MessageRepository;
import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Inject;
import java.util.List;


public class MessageAction extends ActionSupport {

    @Inject
    MessageRepository messageRepository;

    private List<Message> messages;

    public String execute() throws Exception {
        messages = messageRepository.findAllOrderByCreatedAt();
        return SUCCESS;
    }
}