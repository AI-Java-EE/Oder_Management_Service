package com.aga.demo.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TransferDto {
    private String from;
    private String to;
    private BigDecimal amount;
    private String remark;
}