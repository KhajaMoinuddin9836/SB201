package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.AccountService;
import com.masai.model.Account;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accService;
	
	@PostMapping("/account")
	public ResponseEntity<Account> openAccountHandler(@RequestBody Account acc){
		
		Account op = accService.openAccount(acc);
		
		return new ResponseEntity<Account>(op, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{accno}")
	public ResponseEntity<Account> closeAccountHandler(@PathVariable Integer accno){
		
		Account aacc = accService.closeAccount(accno);
		
		return new ResponseEntity<Account>(aacc, HttpStatus.OK);
	}
	
	@PutMapping("/deposit/{accno}")
	public ResponseEntity<Account> depositamount(@PathVariable Integer accno,@RequestBody Integer amount){
		
		return new ResponseEntity<Account>(accService.depositAmount(accno, amount), HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/withdraw/{amount}")
	public ResponseEntity<Account> withdrawamount(@PathVariable Integer accno, @RequestBody Integer amount){
		
		return new ResponseEntity<Account>(accService.withdrawAmount(accno, amount), HttpStatus.OK);
	}
}
