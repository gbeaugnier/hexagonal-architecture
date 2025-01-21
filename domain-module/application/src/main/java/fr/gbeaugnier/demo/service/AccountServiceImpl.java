package fr.gbeaugnier.demo.service;

import fr.gbeaugnier.demo.model.AccountDto;
import fr.gbeaugnier.demo.port.input.AccountService;
import fr.gbeaugnier.demo.port.output.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public void createAccount(AccountDto accountDto) {
        accountRepository
                .findByAccountId(accountDto.getAccountId())
                .ifPresentOrElse(
                        account -> { throw new IllegalArgumentException("Account already exist"); },
                            () -> accountRepository.save(accountDto)
                );
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) {
        accountRepository
                .findByAccountId(accountId)
                .ifPresentOrElse(
                  account -> {
                      account.deposit(amount);
                      accountRepository.save(account);
                  },
                        () -> { throw new IllegalArgumentException("Account not exist"); }
                );
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        accountRepository
                .findByAccountId(accountId)
                .ifPresentOrElse(
                        account -> {
                            account.withdraw(amount);
                            accountRepository.save(account);
                        },
                        () -> { throw new IllegalArgumentException("Account not exist"); }
                );
    }
}
