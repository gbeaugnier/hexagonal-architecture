package fr.gbeaugnier.demo.adapter;

import fr.gbeaugnier.demo.model.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountApiMapper {


    @Mapping(target = "balance", constant = "0")
    AccountDto toNewDto(String accountId);

}
