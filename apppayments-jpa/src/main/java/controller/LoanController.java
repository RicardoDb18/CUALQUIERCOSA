package controller;

import model.Loan;
import model.Payment;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "LoanController")
@RequestScoped
public class LoanController {

    public List<Loan> getLoanList(){

        Payment p = new Payment();
        p.setPaymentAmount(1000.0);
        p.setCreatedDate(LocalDate.of(2015,10,10));

        List<Loan> loanList = new ArrayList<>();
        Loan l = new Loan();
        l.setClientName("Juan");
        l.setClientLastName("Jose");
        l.setLoanAmount(12000.0);
        l.setPaymentList((List<Payment>) p);


        loanList.add(l);



        return loanList;
    }

}
