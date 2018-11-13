package com.banku.accounts.repository;

import com.banku.accounts.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<TransactionEntity, Serializable> {
	
	public List<TransactionEntity> findTransactionEntityByAccountNumber(long accountNumber);
}
