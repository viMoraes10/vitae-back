package com.example.demo.service;

import com.example.demo.dto.ChatDTO;
import com.example.demo.model.Chat;
import com.example.demo.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public List<Chat> getChatsByUser(Integer userId) {
        return chatRepository.findByUserIdOrderByCreatedAtAsc(userId);
    }

    public Chat create(ChatDTO chatDTO) {
        Chat chat = new Chat();
        chat.setUserId(chatDTO.userId());
        chat.setMessage(chatDTO.message());
        chat.setSender(chatDTO.sender());
        chat.setCreatedAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }
}
