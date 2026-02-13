package com.aga.demo.transfer.controller;

import com.aga.demo.transfer.dto.TransferDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    @GetMapping
    public ResponseEntity<List<TransferDto>> list() {
        List<TransferDto> list = new ArrayList<>();
        list.add(new TransferDto("Kbt", "Dara", BigDecimal.valueOf(100), "note"));
        list.add(new TransferDto("Kbt", "Sokha", BigDecimal.valueOf(50), "note"));
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

}
