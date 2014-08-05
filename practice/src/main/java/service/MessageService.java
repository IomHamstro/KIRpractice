package service;

import model.Message;
import org.springframework.stereotype.Service;

/**
 * Created by Ольга on 04.08.2014.
 */
@Service
public interface MessageService {
    Message getMessageById(Long id);
    Iterable<Message> getAllMessages();
    void saveMessage(Message message);
}
