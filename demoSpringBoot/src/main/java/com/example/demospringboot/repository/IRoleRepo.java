package com.example.demospringboot.repository;

import com.example.demospringboot.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepo extends PagingAndSortingRepository<Role, Integer> {
}
