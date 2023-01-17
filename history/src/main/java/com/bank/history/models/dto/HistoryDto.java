package com.bank.history.models.dto;

import lombok.Data;

/**
 * A DTO for the {@link com.bank.history.models.History} entity
 */
@Data
public class HistoryDto {
    private Long id;
    private Long transferAuditId;
    private Long profileAuditId;
    private Long accountAuditId;
    private Long antiFraudAuditId;
    private Long publicBankInfoAuditId;
    private Long authorizationAuditId;
}
