package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends PagingAndSortingRepository<User, Long> {
}
