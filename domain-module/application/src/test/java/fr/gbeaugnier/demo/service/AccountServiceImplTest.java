package fr.gbeaugnier.demo.service;

import fr.gbeaugnier.demo.model.AccountDto;
import fr.gbeaugnier.demo.port.output.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void createAccountWithExistingAccount() {
        AccountDto dto = new AccountDto("12345", BigDecimal.TEN);
        when(accountRepository.findByAccountId(anyString())).thenReturn(Optional.of(dto));

        assertThrows(IllegalArgumentException.class, () -> accountService.createAccount(dto));
    }

    @Test
    void createAccountWithoutExistingAccount() {
        AccountDto dto = new AccountDto("12345", BigDecimal.TEN);
        when(accountRepository.findByAccountId(anyString())).thenReturn(Optional.empty());

        accountService.createAccount(dto);
        verify(accountRepository, new Times(1)).save(any(AccountDto.class));
    }

    @Test
    void depositWithoutAccount() {
        when(accountRepository.findByAccountId(anyString())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> accountService.deposit("12345", BigDecimal.TEN));
    }

    @Test
    void depositWithoutAccountWithoutSold() {
        AccountDto dto = new AccountDto("12345", BigDecimal.TEN);
        when(accountRepository.findByAccountId(anyString())).thenReturn(Optional.of(dto));

        assertThrows(IllegalArgumentException.class, () -> accountService.deposit("12345", BigDecimal.ZERO));
    }

    @Test
    void depositWithAccountWithSold() {
        AccountDto dto = new AccountDto("12345", BigDecimal.TEN);
        when(accountRepository.findByAccountId(anyString())).thenReturn(Optional.of(dto));

        accountService.deposit("12345", BigDecimal.TEN);
        verify(accountRepository, new Times(1)).save(any(AccountDto.class));
    }

    @Test
    void withdrawWithoutAccount() {
        when(accountRepository.findByAccountId(anyString())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> accountService.withdraw("12345", BigDecimal.TEN));
    }

    @Test
    void withdrawWithoutAccountWithoutSold() {
        AccountDto dto = new AccountDto("12345", BigDecimal.TEN);
        when(accountRepository.findByAccountId(anyString())).thenReturn(Optional.of(dto));

        assertThrows(IllegalArgumentException.class, () -> accountService.withdraw("12345", BigDecimal.ZERO));
    }

    @Test
    void withdrawWithAccountWithSold() {
        AccountDto dto = new AccountDto("12345", BigDecimal.TEN);
        when(accountRepository.findByAccountId(anyString())).thenReturn(Optional.of(dto));

        accountService.withdraw("12345", BigDecimal.TWO);
        verify(accountRepository, new Times(1)).save(any(AccountDto.class));
    }

}