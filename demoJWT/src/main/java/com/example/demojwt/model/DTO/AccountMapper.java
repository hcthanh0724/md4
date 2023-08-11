package com.example.demojwt.model.DTO;

import com.example.demojwt.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {
    @Mapping(source = "role.name",target = "roleName")
    AccountDTO accountToAccountDTO(Account account);
}
