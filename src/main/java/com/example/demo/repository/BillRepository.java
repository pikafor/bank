package com.example.demo.repository;

import com.example.demo.model.Bill;
import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByClientId(Long clientId);
}
