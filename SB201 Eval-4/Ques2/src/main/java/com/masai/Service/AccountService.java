package com.masai.Service;

import com.masai.Exceptions.AccountException;
import com.masai.Exceptions.insufficientFundException;
import com.masai.entity.AccountDTO;
import com.masai.model.Account;

public interface AccountService {

	public Account openAccount(Account acc)throws AccountException;
	
	public Account closeAccount(Integer accno)throws AccountException;
	
	public Account depositAmount(Integer accno, Integer amount)throws AccountException;
	
	public Account withdrawAmount(Integer accno, Integer amount)throws AccountException, insufficientFundException;
	
	public String transferAmount(AccountDTO dto)throws AccountException, insufficientFundException;
	
	
}
