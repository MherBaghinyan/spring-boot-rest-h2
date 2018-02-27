package com.banking.service.impl;

import com.banking.domain.BankAccount;
import com.banking.repository.BankAccountRepository;
import com.banking.service.BankAccountService;
import com.banking.service.bean.BankAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Gebruiker on 2/26/2018.
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount getAccountById(Integer id) {
        return bankAccountRepository.findOne(id);
    }

    @Override
    public BankAccount addAccount(BankAccountVO newAccount) {

        BankAccount account = new BankAccount();
        account.setBankName(newAccount.getBankName());
        account.setIban(newAccount.getIban());
        account.setBic(newAccount.getBic());
        account.setAccountNumber(newAccount.getAccountNumber());

        return bankAccountRepository.save(account);
    }

    @Override
    public BankAccount editAccount(Integer id, BankAccountVO model) {

        BankAccount account = bankAccountRepository.findOne(id);

        Assert.notNull(account, "account you are trying to edit doesn't exist");

        account.setBankName(model.getBankName());
        account.setIban(model.getIban());
        account.setBic(model.getBic());
        account.setAccountNumber(model.getAccountNumber());

        return bankAccountRepository.save(account);
    }

    @Override
    public void deleteAccountById(int id) {
        bankAccountRepository.delete(id);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }
}
