package com.message.services;

import com.message.domain.Message;
import com.message.domain.MessageRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageServiceTest {

    private MessageService messageService;
    private MessageRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new MessageRepository();
        repository.init();
        messageService = new MessageService(repository);
    }

    @Test
    public void sendMessage() {
        // given:
        assertThat(repository.findAllOrderByCreatedAtDesc()).isEmpty();

        // when:
        messageService.sendMessage(MessageRequest.of("qwe", "1qqqe"));

        // then:
        assertThat(repository.findAllOrderByCreatedAtDesc()).isNotEmpty();
        // and:
        assertThat(repository.findAllOrderByCreatedAtDesc().size()).isEqualTo(1);
    }

    @Test
    public void findMessagesInDescendOrder() {
        // given:
        assertThat(messageService.findMessagesInDescendOrder()).isEmpty();
        // with:
        messageService.sendMessage(MessageRequest.of("qwe", "1qqqe"));
        // and:
        final Set<Message> actual = repository.findAllOrderByCreatedAtDesc();
        assertThat(actual).isNotEmpty();
        // where:
        final int expected = 1;
        assertThat(actual.size()).isEqualTo(expected);

        // when:
        final List<MessageResponse> result = messageService.findMessagesInDescendOrder();

        // then:
        assertThat(result.size()).isEqualTo(expected);
    }
}