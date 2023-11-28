package com.example.demo.service;

import com.example.demo.model.pojo.BillPojo;
import com.example.demo.model.pojo.ClientPojo;

import java.util.UUID;

public interface ClientService {
    ClientPojo save(ClientPojo clientPojo);

    ClientPojo getById(Long id);
}
