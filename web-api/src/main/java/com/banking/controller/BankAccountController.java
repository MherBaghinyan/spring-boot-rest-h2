package com.banking.controller;

import com.banking.api.common.BankAccountDTO;
import com.banking.domain.BankAccount;
import com.banking.service.BankAccountService;
import com.banking.service.bean.BankAccountVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Gebruiker on 2/23/2018.
 */
@RestController
@RequestMapping("/api")
public class BankAccountController {

    private final Logger logger = LoggerFactory.getLogger(BankAccountController.class);

    @Autowired
    private BankAccountService bankAccountService;

    @RequestMapping(value = "/accounts/all", method = RequestMethod.GET)
    public ResponseEntity<List<BankAccount>> getBankAccounts() throws Exception {

        List<BankAccount> accounts = bankAccountService.getAllBankAccounts();

        if (accounts == null) {
            logger.info("nothing to display");
            return new ResponseEntity<List<BankAccount>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<BankAccount>>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity<BankAccount> getBankAccount(@PathVariable int id) throws Exception {

        BankAccount account = bankAccountService.getAccountById(id);

        if (account == null) {
            logger.info("account you are trying to edit doesn't exist");
            return new ResponseEntity<BankAccount>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<BankAccount>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/new", method = RequestMethod.POST)
    public Integer createBankAccount(@RequestBody BankAccountDTO account) throws Exception {

        if (account == null) {
            logger.info("account you are trying to edit doesn't exist");
            throw new Exception("account not found");
        }

        BankAccountVO model = copyAccountData(account);

        BankAccount newAccount = bankAccountService.addAccount(model);

        return newAccount.getId();
    }

    @RequestMapping(value = "/account/edit", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void editBankAccount(@RequestBody BankAccountDTO account) throws Exception {

        if (account == null) {
            logger.info("account you are trying to edit doesn't exist");
            throw new Exception("account not found");
        }

        BankAccountVO model = copyAccountData(account);
        bankAccountService.editAccount(account.getId(), model);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBankAccount(@PathVariable int id) throws Exception {

        if (bankAccountService.getAccountById(id) == null) {
            logger.info("account you are trying to delete doesn't exist");
            throw new Exception("account not found");
        }

        bankAccountService.deleteAccountById(id);
    }

    private BankAccountVO copyAccountData(BankAccountDTO account) {
        BankAccountVO model = new BankAccountVO();
        model.setBankName(account.getBankName());
        model.setIban(account.getIban());
        model.setBic(account.getBic());
        model.setAccountNumber(account.getAccountNumber());
        return model;
    }
}
