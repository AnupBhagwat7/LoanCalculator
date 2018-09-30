package com.anup.controller;


import com.anup.beans.LoanDetails;
import com.anup.beans.RepaymentSchedule;
import com.anup.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping(value = "/generate-plan", headers = "Accept=application/json")
    public List<RepaymentSchedule> getRepaymentSchedule(@RequestBody LoanDetails loanDetails){

        return loanService.getRepaymentSchedule(loanDetails);

    }
/*
    @GetMapping(value = "/get-plan", headers = "Accept=application/json")
    public List<RepaymentSchedule> getRepaymentSchedule(@RequestBody LoanDetails loanDetails){

        return loanService.getRepaymentSchedule(loanDetails);

    }*/
}
