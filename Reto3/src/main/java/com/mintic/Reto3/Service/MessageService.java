package com.mintic.Reto3.Service;

import org.springframework.stereotype.Service;

import com.mintic.Reto3.Model.Message;
import com.mintic.Reto3.Repository.MessageRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> message1 = messageRepository.getMessage(message.getIdMessage());
            if (message1.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }


    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message>g= messageRepository.getMessage(message.getIdMessage());
            if(!g.isEmpty()){
                if(message.getMessageText()!=null){                    
                    g.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(g.get());
                return g.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Message> g = messageRepository.getMessage(id);
        if(g.isPresent()){
            messageRepository.delete(g.get());
        }
        return flag;
    }
}