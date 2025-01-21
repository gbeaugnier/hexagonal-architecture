package fr.gbeaugnier.demo.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountDtoTest {

    @Test
    void illegal_deposit() {
        AccountDto accountDto = new AccountDto("12345", BigDecimal.ZERO);
        assertThrows(IllegalArgumentException.class, () -> accountDto.deposit(BigDecimal.valueOf(-1)));
    }

    @Test
    void deposit() {
        AccountDto accountDto = new AccountDto("12345", BigDecimal.ZERO);
        accountDto.deposit(BigDecimal.TEN);
        assertEquals(BigDecimal.TEN, accountDto.getBalance());
    }

    @Test
    void illegal_withdraw() {
        AccountDto accountDto = new AccountDto("12345", BigDecimal.TEN);
        assertThrows(IllegalArgumentException.class, () -> accountDto.withdraw(BigDecimal.valueOf(-1)));
    }

    @Test
    void insuffisant_withdraw() {
        AccountDto accountDto = new AccountDto("12345", BigDecimal.TWO);
        assertThrows(IllegalArgumentException.class, () -> accountDto.withdraw(BigDecimal.TEN));
    }

    @Test
    void withdraw() {
        AccountDto accountDto = new AccountDto("12345", BigDecimal.TEN);
        accountDto.withdraw(BigDecimal.TWO);
        assertEquals(BigDecimal.valueOf(8), accountDto.getBalance());
    }
}