package com.example.demo.controller;

import com.example.demo.model.pojo.BillPojo;
import com.example.demo.model.pojo.ClientPojo;
import com.example.demo.service.BillService;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class WebController {
    final ClientService clientService;
    private final BillService billService;

    @GetMapping("home")
    public String getHello() {
        return "home";
    }

    @GetMapping("find")
    public String findById(Model clientModel, @RequestParam("id") long id) {
        clientModel.addAttribute("people", clientService.getById(id));
        clientModel.addAttribute("bills", billService.getBillsByClientId(id));
        System.out.println(clientModel.toString());
        return "profile";
    }
    @GetMapping("create/client")
    public String create() {
        return "new_client";
    }
    @PostMapping("create/has_create_client")
    public String newClient(ClientPojo clientPojo, BillPojo billPojo) {
        //ClientPojo clientPojo = new ClientPojo(1L, "Ivan", "Matskevich", "25.11.2023");
        billService.save(clientService.save(clientPojo).getId(), billPojo);
        return "redirect:/home";
    }
    @PostMapping("create/has_create_bill/debit/{clientId}")
    public String createDebitBills(@PathVariable(value = "clientId") Long clientId, BillPojo billPojo) {
        System.out.println(billPojo.toString());
        billService.save(clientId, billPojo);
        return "redirect:/find?id=" + clientId;
    }
    @PostMapping("create/has_create_bill/credit/{clientId}")
    public String createCreditBills(@PathVariable(value = "clientId") Long clientId, BillPojo billPojo) {
        System.out.println(billPojo.toString());
        billService.save(clientId, billPojo);
        return "redirect:/find?id=" + clientId;
    }
    @GetMapping("create/bill")
    public String createBill() {
        return "new_bill";
    }
    @GetMapping("views_bill/{clientId}")
    public List<BillPojo> getBillsByClientId(@PathVariable(value = "clientId") Long clientId) {
        return billService.getBillsByClientId(clientId);
    }
    @PostMapping("search")
    public String search(@RequestParam("clientId") String clientId) {
        System.out.println(clientId);
        return "redirect:/find?id=" + clientId;
    }
}
