package com.github.sigma.mychat.actions.message.dto;

import com.github.sigma.mychat.actions.message.MessageService;
import com.github.sigma.mychat.actions.message.domain.Message;
import com.github.sigma.mychat.actions.message.domain.MessageRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;

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
        final int expected = 1;
        given_messages_in_database_with_$expected_amount_of_messages(expected);

        // when:
        final List<MessageResponse> result = messageService.findMessagesInDescendOrder();

        // then:
        assertThat(result.size()).isEqualTo(expected);
    }

    private void given_messages_in_database_with_$expected_amount_of_messages(int expected) {
        // given:
        assertThat(messageService.findMessagesInDescendOrder()).isEmpty();
        // with:
        repository.save(new Message("qwe", "1qqqe"));
        // and:
        final Set<Message> actual = repository.findAllOrderByCreatedAtDesc();
        assertThat(actual.size()).isEqualTo(expected);
    }
}