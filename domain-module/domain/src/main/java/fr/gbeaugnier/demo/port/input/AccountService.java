package fr.gbeaugnier.demo.port.input;

import fr.gbeaugnier.demo.model.AccountDto;

import java.math.BigDecimal;

public interface AccountService {

    void createAccount(AccountDto account);
    void deposit(String accountId, BigDecimal amount);
    void withdraw(String accountId, BigDecimal amount);

}
