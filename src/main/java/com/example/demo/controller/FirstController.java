package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.model.pojo.BillPojo;
import com.example.demo.model.pojo.ClientPojo;
import com.example.demo.service.BillService;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FirstController {
    private final ClientService clientService;
    private final BillService billService;

    @GetMapping("/{clientId}")
    public List<BillPojo> getBillsByClientId(@PathVariable(value = "clientId") Long clientId) {
        return billService.getBillsByClientId(clientId);
    }
}
