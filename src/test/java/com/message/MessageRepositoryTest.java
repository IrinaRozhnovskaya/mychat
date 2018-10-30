package com.message;

import com.message.domain.Message;
import com.message.domain.MessageRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MessageRepositoryTest {

    MessageRepository messageRepository;

    @Before
    public void setUp() throws Exception {
        messageRepository = new MessageRepository();
        messageRepository.init();
    }

    @Test
    public void should_save_message() {
        given_empty_messages_database();
        when_message_saved_with_$from_and_$body("ollo", "trololo");
        then_findAllOrderByCreatedAt_method_returns_list_with_size(1);
    }

    @Test
    public void should_sort_messages_in_desc_order() throws Exception {
        when_given_$messages_where_saved("ololo", "trololo", "latest");
        expect_findAllOrderByCreatedAt_method_returns_list_in_given_order();
    }

    @After
    public void tearDown() throws Exception {
        messageRepository = null;
    }

    // should_save_message
    private void then_findAllOrderByCreatedAt_method_returns_list_with_size(int size) {
        // then
        assertThat("Unexpected messages number in repository",
                messageRepository.findAllOrderByCreatedAtDesc().size(), equalTo(size));
    }

    private void when_message_saved_with_$from_and_$body(String from, String body) {
        // when
        messageRepository.save(new Message(from, body));
    }

    private void given_empty_messages_database() {
        assertThat("Unexpected messages number in repository",
                messageRepository.findAllOrderByCreatedAtDesc().size(), equalTo(0));
    }

    // should_sort_messages_in_desc_order

    private void expect_findAllOrderByCreatedAt_method_returns_list_in_given_order() {
        final Set<List<Message>> messages = messageRepository.findAllOrderByCreatedAtDesc();
        int ordered = messages.size() - 1;
        for (List<Message> message1 : messages) {
            for (Message message: message1) {
                final String senderName = message.getFrom();
                assertThat("message was received in wrong order", senderName, equalTo("" + ordered));
                ordered--;
            }
        }
    }

    private void when_given_$messages_where_saved(String... messages) throws InterruptedException {
        for (int order = 0; order < messages.length; order++) {
            messageRepository.save(new Message("" + order, messages[order]));
            MILLISECONDS.sleep(100);
        }
    }
}