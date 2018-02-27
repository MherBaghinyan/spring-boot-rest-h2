package com.banking.service;

import com.banking.domain.BankAccount;
import com.banking.service.bean.BankAccountVO;

import java.util.List;

/**
 * Created by Gebruiker on 2/26/2018.
 */
public interface BankAccountService {

    BankAccount getAccountById(Integer id);

    BankAccount addAccount(BankAccountVO newAccount);

    BankAccount editAccount(Integer id, BankAccountVO newAccount);

    void deleteAccountById(int id);

    List<BankAccount> getAllBankAccounts();
}
