package com.actions;

import com.message.domain.Message;
import com.message.domain.MessageRepository;
import com.message.services.MessageRequest;
import com.message.services.MessageService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Set;


@SessionScoped
public class MessageAction extends ActionSupport implements SessionAware {

    @Inject
    MessageRepository messageRepository;

    String from, body;
    Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    void sendMessage() {
        if (body == null) return;
        if (body.trim().equals("")) return;

        final Object key = session.values();

        messageRepository.save(new Message(String.valueOf(key), body));
    }

    @Override
    @Action("/*")
    public String execute() {
        sendMessage();
        return "index";
    }

    public Set<List<Message>> getMessages() {
        return messageRepository.findAllOrderByCreatedAtDesc();
    }
}
