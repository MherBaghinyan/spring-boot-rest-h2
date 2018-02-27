package com.banking.api.common;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Gebruiker on 2/24/2018.
 */
@ApiModel
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class BankAccountDTO {

    @ApiModelProperty
    private Integer id;
    @ApiModelProperty
    private String accountNumber;
    @ApiModelProperty
    private String bankName;
    @ApiModelProperty
    private String iban;
    @ApiModelProperty
    private Integer bic;

    public BankAccountDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
