package com.bank.history.models.dto;

import com.bank.history.models.History;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HistoryMapper {
    History toEntity(HistoryDto historyDto);

    HistoryDto toDto(History history);
}
