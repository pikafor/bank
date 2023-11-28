package com.example.demo.service;

import com.example.demo.model.pojo.BillPojo;

import java.util.List;

public interface BillService {
    BillPojo save(Long ClientId, BillPojo billPojo);
    BillPojo findById(Long id);
    List<BillPojo> getBillsByClientId(Long id);
}
