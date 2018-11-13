package com.banku.accounts.controllers;

import com.banku.accounts.entities.AccountEntity;
import com.banku.accounts.entities.TransactionEntity;
import com.banku.accounts.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody AccountEntity accountEntity) {
		ResponseEntity<Object> responseEntity = accountService.createAccount(accountEntity);
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> update(@RequestBody AccountEntity accountEntity) {
		ResponseEntity<Object> responseEntity = accountService.updateAccount(accountEntity);
		
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<Object> findAll() {
		ResponseEntity<Object> responseEntity = accountService.findAllAccounts();
		
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("/findByAccount")
	public ResponseEntity<Object> findByAccount(@RequestParam long account) {
		ResponseEntity<Object> responseEntity = accountService.findByAccount(account);
		
		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping("/findByDocument")
	public ResponseEntity<Object> findByDocument(@RequestParam int document) {
		ResponseEntity<Object> responseEntity = accountService.findByDocument(document);

		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}

	@PostMapping("/transaction")
	public ResponseEntity<Object> transaction(@RequestBody TransactionEntity transactionEntity) {
		ResponseEntity<Object> responseEntity = accountService.transaction(transactionEntity);

		if (responseEntity.hasBody()) {
			return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
		}
		return responseEntity;
	}

}
