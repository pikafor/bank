package com.example.demo.model.pojo;

import com.example.demo.model.Bill;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientPojo {
    private Long id;
    private String firstName;
    private String secondName;
    private String createDate;
}
