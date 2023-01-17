package com.bank.history.controllers;

import com.bank.history.models.dto.HistoryDto;
import com.bank.history.services.abstracts.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping(path = "/{id}")
    public HistoryDto getHistoryById(@PathVariable("id") Long id) {
        return historyService.findById(id);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<HistoryDto>> getAll() {
        return ResponseEntity.ok(historyService.getAll());
    }

    @PostMapping(path = "/save")
    public void addHistory(@RequestBody HistoryDto historyDto) {
        historyService.save(historyDto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<HistoryDto> updateHistory(@PathVariable("id") Long id, @RequestBody HistoryDto historyDto) {
        return ResponseEntity.ok(historyService.updateHistory(id, historyDto));

    }

//    @PatchMapping(path = "/{id}")
//    public ResponseEntity<HistoryDto> updatePartsHistory(@PathVariable("id") Long id,
//                                                         @RequestBody HistoryDto historyDto) {
//        return ResponseEntity.ok(historyService.updatePartsHistory(id, historyDto));
//    }
}
