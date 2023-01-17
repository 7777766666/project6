package com.bank.history.services.model;

import com.bank.history.exception.ResourceNotFoundException;
import com.bank.history.models.History;
import com.bank.history.models.dto.HistoryDto;
import com.bank.history.models.dto.HistoryMapper;
import com.bank.history.repositories.HistoryRepository;
import com.bank.history.services.abstracts.HistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;
    public HistoryServiceImpl(HistoryRepository historyRepository,
                              HistoryMapper historyMapper) {
        this.historyRepository = historyRepository;
        this.historyMapper = historyMapper;
    }
    @Override
    public void save(HistoryDto historyDto) {
        final History history = historyMapper.toEntity(historyDto);
        historyRepository.save(history);
    }
    public HistoryDto findById(Long id) {
        return historyMapper.toDto(historyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("History with " + id + "id not found")));
    }
    @Transactional
    public HistoryDto updateHistory(Long id, HistoryDto historyDto) {
        historyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("History was not update, where id = " + id ));
        final History historyFromController = historyMapper.toEntity(historyDto);
        historyFromController.setId(id);
        final History historyUpdate = historyRepository.save(historyFromController);
        return historyMapper.toDto(historyUpdate);
    }
    @Override
    public List<HistoryDto> getAll() {
        return historyRepository.findAll().stream()
                .map(historyMapper::toDto).collect(Collectors.toList());
    }
}
