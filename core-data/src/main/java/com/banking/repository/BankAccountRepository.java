package com.banking.repository;

import com.banking.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Gebruiker on 2/22/2018.
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
}
