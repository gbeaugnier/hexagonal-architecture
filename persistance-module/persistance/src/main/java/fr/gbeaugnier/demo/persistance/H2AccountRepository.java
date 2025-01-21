package fr.gbeaugnier.demo.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface H2AccountRepository extends CrudRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByAccountId(String accountId);

}
