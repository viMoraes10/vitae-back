package com.example.demo.controller;

import com.example.demo.dto.OccurrenceDTO;
import com.example.demo.dto.UpdateOccurrenceStatusDTO;
import com.example.demo.model.Report;
import com.example.demo.service.OccurrenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for handling endpoints related to occurrences (denúncias).
 */
@RestController
@RequestMapping(value = "/api/occurrences")
@Tag(name = "Ocorrências")
public class OccurrenceController {

    @Autowired
    private OccurrenceService occurrenceService;

    @Operation(summary = "Lista todas as ocorrências de denúncia")
    @GetMapping
    public ResponseEntity<?> getAllOccurrences() {
        try {
            return ResponseEntity.ok(occurrenceService.getAllOccurrences());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @Operation(summary = "Busca ocorrência de denúncia por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOccurrenceById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(occurrenceService.getOccurrenceById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @Operation(summary = "Cria uma ocorrência de denúncia")
    @PostMapping
    public ResponseEntity<?> createOccurrence(@RequestBody @Valid OccurrenceDTO occurrenceDTO) {
        try {
            Report created = occurrenceService.createOccurrence(occurrenceDTO);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @Operation(summary = "Atualiza o status de uma ocorrência de denúncia")
    @PatchMapping(value = "/{id}/status")
    public ResponseEntity<?> updateOccurrenceStatus(@PathVariable Long id,
                                                    @RequestBody @Valid UpdateOccurrenceStatusDTO statusDTO) {
        try {
            Report updated = occurrenceService.updateStatus(id, statusDTO.status());
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }
}
