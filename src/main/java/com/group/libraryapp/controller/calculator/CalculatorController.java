package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calcaulator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calcaulator.request.CalculatorMutiplyRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMutiplyRequest request){
        return request.getNumber1()* request.getNumber2();
    }

}
