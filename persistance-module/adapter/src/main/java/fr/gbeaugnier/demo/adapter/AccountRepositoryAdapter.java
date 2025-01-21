package fr.gbeaugnier.demo.adapter;

import fr.gbeaugnier.demo.model.AccountDto;
import fr.gbeaugnier.demo.persistance.AccountEntity;
import fr.gbeaugnier.demo.persistance.H2AccountRepository;
import fr.gbeaugnier.demo.port.output.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {

    private final H2AccountRepository accountRepository;
    private final AccountPersistanceMapper accountPersistanceMapper;

    @Override
    public Optional<AccountDto> findByAccountId(String accountId) {
        return accountRepository.findByAccountId(accountId).map(accountPersistanceMapper::toDto);
    }

    @Override
    public void save(AccountDto accountDto) {
        AccountEntity entity = accountRepository
                .findByAccountId(accountDto.getAccountId())
                .orElse(new AccountEntity());
        accountPersistanceMapper.updateAccount(entity, accountDto);
        accountRepository.save(entity);
    }
}
