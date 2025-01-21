package fr.gbeaugnier.demo.port.output;

import fr.gbeaugnier.demo.model.AccountDto;

import java.util.Optional;

public interface AccountRepository {

    Optional<AccountDto> findByAccountId(String accountId);
    void save(AccountDto accountDto);
}
