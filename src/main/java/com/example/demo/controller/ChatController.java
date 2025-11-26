package com.example.demo.controller;

import com.example.demo.dto.ChatDTO;
import com.example.demo.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/chats")
@Tag(name = "Chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Operation(summary = "Lista todas as mensagens")
    @GetMapping
    public ResponseEntity<?> getAllChats() {
        try {
            return ResponseEntity.ok(chatService.getAllChats());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @Operation(summary = "Lista mensagens por usuário")
    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<?> getChatsByUser(@PathVariable Integer userId) {
        try {
            return ResponseEntity.ok(chatService.getChatsByUser(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @Operation(summary = "Cria uma nova mensagem")
    @PostMapping
    public ResponseEntity<?> postChat(@RequestBody @Valid ChatDTO chatDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(chatService.create(chatDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }
}
