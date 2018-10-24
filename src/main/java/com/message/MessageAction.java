package com.message;

import com.opensymphony.xwork2.ActionSupport;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;

import static com.utils.StringUtils.isNullOrEmpty;


@Stateless
public class MessageAction extends ActionSupport {

    @Inject
    MessageService messageService;

    private String from, body;

    public void setFrom(final String from) {
        this.from = from;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    public String execute() throws Exception {
        if (messageService.isDataValid(from, body)) {
            messageService.save(new Message(from, body));
        }
        return SUCCESS;
    }

    public void validate() {
        if (isNullOrEmpty(from)) { /* TODO */ }
        if (isNullOrEmpty(body)) { /* TODO */ }

        if (!messageService.isDataValid(from, body)) {
            addFieldError("from", "Enter your name, please.");
            addFieldError("body", "Enter message, please.");
        }
    }

    public Set<Message> getMessages() {
        return messageService.tailMessages();
    }
}
