package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.AccountException;
import com.masai.Exceptions.insufficientFundException;
import com.masai.entity.AccountDTO;
import com.masai.model.Account;
import com.masai.repository.AccountDao;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao acDao;

	@Override
	public Account openAccount(Account acc) throws AccountException {
		
		Account account = acDao.save(acc);
		
		return account;
	}

	@Override
	public Account closeAccount(Integer accno) throws AccountException {
		
		Account acc = acDao.findById(accno).orElseThrow(()-> new AccountException("Account closed..."));
		
		acDao.delete(acc);
		
		return acc;
	}

	@Override
	public Account depositAmount(Integer accno, Integer amount) throws AccountException {
	
		Optional<Account> Oa = acDao.findById(accno);
		
		if(Oa.isPresent()) {
			
			Account Acc = Oa.get();
			
			Acc.setBalance(Acc.getBalance()+amount);
			
			return acDao.save(Acc);
		}
		
		throw new AccountException("no Account available with accNo :"+accno);
	}

	@Override
	public Account withdrawAmount(Integer accno, Integer amount) throws AccountException, insufficientFundException {
		
		Optional<Account> wd = acDao.findById(accno);
		
		if(wd.isPresent()) {
			
			Account Acc = wd.get();
			
			Acc.setBalance(Acc.getBalance()-amount);
			
			return acDao.save(Acc);
		}

		if(amount < 0) {
			
			throw new insufficientFundException("insufficient balance"); 
		}
		
		throw new AccountException("Invalid accNo :"+ accno);
		
	}

	@Override
	public String transferAmount(AccountDTO dto) throws AccountException, insufficientFundException {
		
		String str = "";
		
		AccountDTO ATO = new AccountDTO();
		
		Account Acc = new Account();
		
		Optional<Account> aoc = acDao.findOne((Example<Account>) dto);
		
		if(ATO.getSrcAccno() != Acc.getAccountNo() || ATO.getDesAccno() != Acc.getAccountNo()) {
			
			throw new AccountException("No Account with account no :"+dto.getSrcAccno());
		}
		else {
			
			aoc.get();
			
			Acc.setBalance(Acc.getBalance()+dto.getAmount());
			str = "Amount transferred successfully";
			
		}
		
		if(dto.getAmount() == null || dto.getAmount() < 0) {
			
			throw new insufficientFundException("insufficient Amount");
		}
		else {
			
			str = "Amount is transferred successfully";
		}
		
		return str;
	}

}
