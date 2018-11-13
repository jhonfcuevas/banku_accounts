package com.banku.accounts.repository;

import com.banku.accounts.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<AccountEntity, Serializable> {

	public AccountEntity findAccountEntityByAccountNumber (long accountNumber);

	public AccountEntity findAccountEntityByDocumentClient(int documentClient);

}
