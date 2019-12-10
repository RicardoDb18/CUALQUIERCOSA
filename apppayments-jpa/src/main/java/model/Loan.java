package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "loanNumber")
    private Integer loanNumber;
    @JoinColumn(name = "clientName")
    private String clientName;
    @JoinColumn(name = "clientLastName")
    private String clientLastName;
    @JoinColumn(name = "loanAmount")
    private Double loanAmount;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> paymentList = new ArrayList<>();

    public Loan() {
    }

    public Loan(Integer loanNumber, String clientName, String clientLastName, Double loanAmount, List<Payment> paymentList) {
        this.loanNumber = loanNumber;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.loanAmount = loanAmount;
        this.paymentList = paymentList;
    }

    public Integer getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Integer loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanNumber=" + loanNumber +
                ", clientName='" + clientName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", loanAmount=" + loanAmount +
                ", paymentList=" + paymentList +
                '}';
    }
}

