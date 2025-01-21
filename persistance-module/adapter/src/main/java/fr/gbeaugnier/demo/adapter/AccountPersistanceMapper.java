package fr.gbeaugnier.demo.adapter;

import fr.gbeaugnier.demo.model.AccountDto;
import fr.gbeaugnier.demo.persistance.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountPersistanceMapper {

    AccountDto toDto(AccountEntity entity);
    void updateAccount(@MappingTarget AccountEntity entity, AccountDto dto);

}
