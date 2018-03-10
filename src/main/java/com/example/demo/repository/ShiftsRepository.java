package com.example.demo.repository;

import com.example.demo.domain.Shift;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftsRepository extends PagingAndSortingRepository<Shift,Long> {
}
