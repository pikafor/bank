package com.example.demo.service.impl;

import com.example.demo.model.Client;
import com.example.demo.model.pojo.BillPojo;
import com.example.demo.model.pojo.ClientPojo;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.BillService;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final BillService billService;

    @Override
    public ClientPojo save(ClientPojo clientPojo) {
        return toPojo(clientRepository.save(toEntity(clientPojo)));
    }

    @Override
    public ClientPojo getById(Long id) {
        return toPojo(clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Пользователь не найден!")));
    }

    private Client toEntity(ClientPojo clientPojo) {
        return Client.builder()
                .id(clientPojo.getId())
                .firstName(clientPojo.getFirstName())
                .secondName(clientPojo.getSecondName())
                .createDate(clientPojo.getCreateDate()).build();
    }

    private ClientPojo toPojo(Client client) {
        return ClientPojo.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .secondName(client.getSecondName())
                .createDate(client.getCreateDate()).build();
    }
}
