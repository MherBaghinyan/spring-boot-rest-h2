package com.banking.domain;

import javax.persistence.*;

/**
 * Created by Gebruiker on 2/22/2018.
 */
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    @Column(name = "bank_name", nullable = false)
    private String bankName;
    @Column(name = "iban", nullable = false)
    private String iban;
    @Column(name = "bic", nullable = false)
    private Integer bic;

    public BankAccount() {
        super();
    }

    public BankAccount(Integer id, Integer bic, String iban, String bankName, String accountNumber) {
        this.id = id;
        this.bic = bic;
        this.iban = iban;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBic() {
        return bic;
    }

    public void setBic(Integer bic) {
        this.bic = bic;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", bankName='" + bankName + '\'' +
                ", iban='" + iban + '\'' +
                ", bic=" + bic +
                '}';
    }
}