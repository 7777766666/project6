package com.bank.history.services.abstracts;

import com.bank.history.models.dto.HistoryDto;
import java.util.List;

public interface HistoryService {

    void save(HistoryDto historydto);

    HistoryDto findById(Long id);

    List<HistoryDto> getAll();
    HistoryDto updateHistory(Long id, HistoryDto historydto);
}
