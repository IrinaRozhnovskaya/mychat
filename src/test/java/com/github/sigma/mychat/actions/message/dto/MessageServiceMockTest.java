package com.github.sigma.mychat.actions.message.dto;

import com.github.sigma.mychat.actions.message.MessageService;
import com.github.sigma.mychat.actions.message.domain.Message;
import com.github.sigma.mychat.actions.message.domain.MessageRepository;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageServiceMockTest {

    private MessageService messageService;
    private MessageRepository repository;

    @Before
    public void setUp() {
        repository = mock(MessageRepository.class);
        messageService = new MessageService(repository);
    }

    @Test
    public void sendMessage() {
        // given:
        Set<Message> emptyMessageSet = new TreeSet<>();
        Message message = new Message("qwe", "1qqqe");
        Set<Message> messageSet = new TreeSet<>();
        messageSet.add(message);
        when(repository.findAllOrderByCreatedAtDesc()).thenReturn(emptyMessageSet).thenReturn(messageSet);
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
        Message message = new Message("qwe", "1qqqe");
        Set<Message> messageSet = new TreeSet<>();
        messageSet.add(message);

        // given:
        assertThat(messageService.findMessagesInDescendOrder()).isEmpty();

        // with:
        doNothing().when(repository).save(new Message("qwe","1qqqe"));
        repository.save(new Message("qwe", "1qqqe"));
        // and:
        when(repository.findAllOrderByCreatedAtDesc()).thenReturn(messageSet);
        final Set<Message> actual = repository.findAllOrderByCreatedAtDesc();
        assertThat(actual.size()).isEqualTo(expected);
    }
}

