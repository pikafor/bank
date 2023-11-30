package com.example.demo.service.impl;

import com.example.demo.model.Bill;
import com.example.demo.model.Client;
import com.example.demo.model.pojo.BillPojo;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.BillService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;
    private final ClientRepository clientRepository;
    @Value("${bill.debit.money}")
    private Long defaultDebitMoney;
    @Value("${bill.credit.money}")
    private Long defaultCreditMoney;

    public BillServiceImpl(BillRepository billRepository, ClientRepository clientRepository) {
        this.billRepository = billRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public BillPojo save(Long clientId, BillPojo billPojo) {
        if (billPojo.getType().equals("кредитная"))
            billPojo.setMoney(defaultCreditMoney);
        if (billPojo.getType().equals("дебетовая"))
            billPojo.setMoney(defaultDebitMoney);
        billPojo.setCreateDate(getDate());
        Bill bill = toEntity(billPojo);
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Пользователь не найден!"));
        bill.setClient(client);
        Bill newBill = billRepository.save(bill);
        return toPojo(newBill);
    }

    @Override
    public BillPojo findById(Long id) {
        return toPojo(billRepository.findById(id).orElseThrow(() -> new IllegalArgumentException()));
    }

    @Override
    public List<BillPojo> getBillsByClientId(Long id) {
        return billRepository.findByClientId(id).stream().map(bill -> toPojo(bill)).collect(Collectors.toList());
    }

    private Bill toEntity(BillPojo billPojo) {
        return Bill.builder()
                .money(billPojo.getMoney())
                .createDate(billPojo.getCreateDate())
                .type(billPojo.getType())
                .build();
    }

    private BillPojo toPojo(Bill bill) {
        return BillPojo.builder()
                .money(bill.getMoney())
                .createDate(bill.getCreateDate())
                .type(bill.getType())
                .build();
    }

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }
}
