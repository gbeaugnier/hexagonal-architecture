package fr.gbeaugnier.demo.adapter;

import fr.gbeaugnier.demo.payload.AccountRequest;
import fr.gbeaugnier.demo.port.input.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountApiAdapter {

    private final AccountService accountService;
    private final AccountApiMapper accountApiMapper;

    public void createAccount(String accountId) {
        accountService.createAccount(accountApiMapper.toNewDto(accountId));
    }

    public void deposit(AccountRequest request) {
        accountService.deposit(request.accountId(), request.amount());
    }

    public void withdraw(AccountRequest request) {
        accountService.withdraw(request.accountId(), request.amount());
    }

}
