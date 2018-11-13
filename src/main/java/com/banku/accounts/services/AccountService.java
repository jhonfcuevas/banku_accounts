package com.banku.accounts.services;

import com.banku.accounts.entities.AccountEntity;
import com.banku.accounts.entities.TransactionEntity;
import com.banku.accounts.repository.AccountRepository;
import com.banku.accounts.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountService {

    @Autowired
    @Qualifier("accountRepository")
    private AccountRepository accountRepository;

    @Autowired
    @Qualifier("transactionRepository")
    private TransactionRepository transactionRepository;

    public ResponseEntity<Object> createAccount(AccountEntity accountEntity) {
        try {
            accountEntity.setAccountId(0);
            AccountEntity accountEntity2 = accountRepository.save(accountEntity);

            return new ResponseEntity<>(accountEntity2, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> updateAccount(AccountEntity accountEntity) {
        try {
            AccountEntity accountEntity2 = accountRepository.findAccountEntityByAccountNumber(accountEntity.getAccountNumber());

            if (accountEntity2 != null) {
                accountEntity.setAccountId(accountEntity2.getAccountId());
                AccountEntity catalogEntity3 = accountRepository.save(accountEntity);
                return new ResponseEntity<>(catalogEntity3, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> findAllAccounts() {
        try {
            List<AccountEntity> accountsEntities = accountRepository.findAll();

            for (AccountEntity accountEntity : accountsEntities) {
                List<TransactionEntity> transactionEntities = transactionRepository.findTransactionEntityByAccountNumber(accountEntity.getAccountNumber());
                accountEntity.setTransactionEntities(transactionEntities);
            }

            return new ResponseEntity<>(accountsEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> findByAccount(long accountNumber) {
        try {
            List<TransactionEntity> transactionEntities = transactionRepository.findTransactionEntityByAccountNumber(accountNumber);
            AccountEntity accountEntity = accountRepository.findAccountEntityByAccountNumber(accountNumber);
            accountEntity.setTransactionEntities(transactionEntities);
            return new ResponseEntity<>(accountEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> findByDocument(int documentClient) {
        try {
            AccountEntity catalogEntity = accountRepository.findAccountEntityByDocumentClient(documentClient);
            List<TransactionEntity> transactionEntities = transactionRepository.findTransactionEntityByAccountNumber(catalogEntity.getAccountNumber());
            catalogEntity.setTransactionEntities(transactionEntities);
            return new ResponseEntity<>(catalogEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> transaction(TransactionEntity transactionEntity) {
        try {
            List<TransactionEntity> transactionEntity2 = transactionRepository.findTransactionEntityByAccountNumber(transactionEntity.getAccountNumber());

            if (!transactionEntity2.isEmpty()) {
                transactionEntity.setTransactionId(transactionEntity2.get(0).getTransactionId());
                TransactionEntity transactionEntity1 = transactionRepository.save(transactionEntity);
                return new ResponseEntity<>(transactionEntity1, HttpStatus.OK);
            } else {
                transactionEntity.setTransactionId(0);
                TransactionEntity transactionEntity3 = transactionRepository.save(transactionEntity);
                return new ResponseEntity<>(transactionEntity3, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
