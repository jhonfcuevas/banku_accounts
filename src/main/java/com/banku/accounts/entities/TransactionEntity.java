package com.banku.accounts.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "transactionid")
    private int transactionId;

    @Column(name = "accountnumber")
    private long accountNumber;

    //SALDO
    @Column(name = "balance")
    private long balance;

    @Column(name = "debit")
    private long debit;

    @Column(name = "credit")
    private long credit;

    @Column(name = "state")
    private String state;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
    @Column(name = "createDate")
    private Date createDate;

    public TransactionEntity(int transactionId, long accountNumber, long balance, long debit, long credit,
                             String state, Date createDate) {
        super();
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.debit = debit;
        this.credit = credit;
        this.state = state;
        this.createDate = createDate;
    }

    public TransactionEntity() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getDebit() {
        return debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "TransactionEntity{" +
                "transactionId=" + transactionId +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", debit=" + debit +
                ", credit=" + credit +
                ", state='" + state + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
