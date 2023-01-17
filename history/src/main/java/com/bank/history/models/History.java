package com.bank.history.models;

import lombok.Data;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@ToString(exclude = "id")
@Table(name = "history")
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "transfer_audit_id")
    Long transferAuditId;
    @Column(name = "profile_audit_id")
    Long profileAuditId;
    @Column(name = "account_audit_id")
    Long accountAuditId;
    @Column(name = "anti_fraud_audit_id")
    Long antiFraudAuditId;
    @Column(name = "public_bank_info_audit_id")
    Long publicBankInfoAuditId;
    @Column(name = "authorization_audit_id")
    Long authorizationAuditId;
}
