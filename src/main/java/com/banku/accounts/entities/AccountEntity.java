package com.banku.accounts.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "accountid")
    private int accountId;

    @Column(name = "documentclient")
    private int documentClient;

    @Column(name = "accounttype")
    private String accountType;

    @Column(name = "accountnumber")
    private long accountNumber;

    @Column(name = "enabled")
    private boolean enabled;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
    @Column(name = "createDate")
    private Date createDate;

    @Transient
    private List<TransactionEntity> transactionEntities;

    public AccountEntity(int accountId, int documentClient, String accountType, long accountNumber, boolean enabled,
                         Date createDate, List<TransactionEntity> transactionEntities) {
        super();
        this.accountId = accountId;
        this.documentClient = documentClient;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.enabled = enabled;
        this.createDate = createDate;
        this.transactionEntities = transactionEntities;
    }

    public AccountEntity() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getDocumentClient() {
        return documentClient;
    }

    public void setDocumentClient(int documentClient) {
        this.documentClient = documentClient;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<TransactionEntity> getTransactionEntities() {
        return transactionEntities;
    }

    public void setTransactionEntities(List<TransactionEntity> transactionEntities) {
        this.transactionEntities = transactionEntities;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "accountId=" + accountId +
                ", documentClient=" + documentClient +
                ", accountType='" + accountType + '\'' +
                ", accountNumber=" + accountNumber +
                ", enabled=" + enabled +
                ", createDate=" + createDate +
                ", transactionEntities=" + transactionEntities +
                '}';
    }

}
