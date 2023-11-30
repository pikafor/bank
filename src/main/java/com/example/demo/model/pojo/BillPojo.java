package com.example.demo.model.pojo;

import com.example.demo.model.BillEnum;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BillPojo {
    private long money;
    private String createDate;
    private BillEnum type;
}
