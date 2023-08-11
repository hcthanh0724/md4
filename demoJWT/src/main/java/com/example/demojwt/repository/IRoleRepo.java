package com.example.demojwt.repository;

import com.example.demojwt.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepo extends PagingAndSortingRepository<Role,Integer> {
}
