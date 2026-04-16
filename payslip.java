package com.example.payslip;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    @GetMapping("/")
    public Map<String, Object> getPayslip() {
        Map<String, Object> payslip = new HashMap<>();
        double basicPay = 50000.0;
        double da = 0.97 * basicPay; // 97% DA
        double hra = 0.10 * basicPay; // 10% HRA
        double pf = 0.12 * basicPay; // 12% PF
        double grossPay = basicPay + da + hra;
        double netSalary = grossPay - pf;

        payslip.put("Employee Name", "John Doe");
        payslip.put("Basic Pay", basicPay);
        payslip.put("DA (97%)", da);
        payslip.put("HRA (10%)", hra);
        payslip.put("PF (12%)", pf);
        payslip.put("Gross Salary", grossPay);
        payslip.put("Net Salary", netSalary);
        
        return payslip;
    }
}
