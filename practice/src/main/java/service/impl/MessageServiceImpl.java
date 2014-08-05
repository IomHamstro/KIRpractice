package service.impl;

import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MessageRepository;
import service.MessageService;

/**
 * Created by Ольга on 04.08.2014.
 */
@Service
public class MessageServiceImpl implements MessageService{

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }



    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findOne(id);
    }

    @Override
    public Iterable<Message> getAllMessages() {
        return messageRepository.findAllOrderBy();
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
