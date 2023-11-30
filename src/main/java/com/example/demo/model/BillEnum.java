package com.example.demo.model;

public enum BillEnum {
    CREDIT("Кредитка"),
    DEBIT("Дебетовая");

    BillEnum(String label) {
       this.label = label;
    }


    private final String label;
}
