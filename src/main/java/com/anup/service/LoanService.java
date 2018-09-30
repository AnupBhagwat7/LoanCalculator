package com.anup.service;


import com.anup.beans.LoanDetails;
import com.anup.beans.RepaymentSchedule;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoanService {


    public List<RepaymentSchedule> getRepaymentSchedule(LoanDetails loanDetails) {

        Map<Integer, RepaymentSchedule> map = calcMonthlyEMI(loanDetails.getPrincipal(), loanDetails.getInterest(), loanDetails.getTenure(), loanDetails.getStartDate());
        System.out.print("Monthly EMI= "+ map);

        //Get the values from map
        List<RepaymentSchedule> repaymentSchedule = map.values().stream()
                .collect(Collectors.toList());

        return repaymentSchedule;
    }


    public static Double calcAnnuity(double principal, double interestRate, double n) {

        double annuity = (principal * interestRate * (Math.pow((1 + interestRate), n)) / ((Math.pow((1 + interestRate), n)) - 1));

        return annuity;
    }

    public static Map<Integer, RepaymentSchedule> calcMonthlyEMI(double p, double rate, double n, Date startDate) {

        Map<Integer, RepaymentSchedule> repaymentMap = new HashMap<>();
        double interestRate = (rate / 12) / 100;
        n = n * 12;
        double principal = p;
        double e = calcAnnuity(principal, interestRate, n);
        double totalInt = Math.round((e * n) - p);
        double totalAmt = Math.round((e * n));

        double intPerMonth = Math.round(totalInt / n);

        for (int i = 1; i <= n; i++) {
            intPerMonth = (principal * interestRate);
            principal = ((principal) - ((e) - (intPerMonth)));

            String strDate;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(i!=1){
                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);
                cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+1));
                startDate = cal.getTime();

                strDate = dateFormat.format(startDate);

            }else{
                strDate = dateFormat.format(startDate);
            }

            repaymentMap.put(i, new RepaymentSchedule(i,strDate , Math.round(e), Math.round((e) - intPerMonth),Math.round(intPerMonth),Math.round(principal)  ));

        }

    return repaymentMap;
    }


    public static void main(String[] args ){

        LoanDetails loanDetails = new LoanDetails();
        loanDetails.setPrincipal(1000);
        loanDetails.setInterest(10);
        loanDetails.setTenure(2);
        loanDetails.setStartDate(new Date());

        System.out.print("EMI=" + calcAnnuity(loanDetails.getPrincipal(), loanDetails.getInterest(), loanDetails.getTenure()));

         calcMonthlyEMI(loanDetails.getPrincipal(), loanDetails.getInterest(), loanDetails.getTenure(), loanDetails.getStartDate());
    }

}
