package com.banking.controller;

import com.banking.domain.BankAccount;
import com.banking.service.BankAccountService;
import com.banking.service.bean.BankAccountVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Gebruiker on 2/26/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankAccountController.class)
public class BankAccountControllerTest {

    private MockMvc mvc;

    @MockBean
    private BankAccountService bankAccountService;

    @InjectMocks
    private BankAccountController bankAccountController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(bankAccountController).build();
    }

    @Test
    @Ignore
    public void addBankAccount() throws Exception {

        BankAccountVO account = createAccountData();

        when(bankAccountService.addAccount(account)).thenReturn(isA(BankAccount.class));

        mvc.perform(
                post("http://localhost:5454/api/account/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(account)))
                .andExpect(status().isCreated());
    }

    @Test
    @Ignore
    public void getBankAccount() throws Exception {

        Integer testId = 7;

        when(bankAccountService.getAccountById(testId)).thenReturn(isA(BankAccount.class));

        mvc.perform(MockMvcRequestBuilders.get("http://localhost:5454/api/account/{id}", testId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    private BankAccountVO createAccountData() {
        BankAccountVO model = new BankAccountVO();
        model.setBankName("INECOBANK");
        model.setIban("CY17 0020 0128 0000 0012 0052 7600");
        model.setBic(3242422);
        model.setAccountNumber("931234881212");
        return model;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
