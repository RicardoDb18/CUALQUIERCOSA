package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "paymentId")
    private Integer paymentId;
    @JoinColumn(name = "paymentAmount")
    private Double paymentAmount;
    @JoinColumn(name = "createdDate")
    private LocalDate createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id")
    private Loan loan;

    public Payment() {
    }

    public Payment(Integer paymentId, Double paymentAmount, LocalDate createdDate, Loan loan) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.createdDate = createdDate;
        this.loan = loan;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentAmount=" + paymentAmount +
                ", createdDate=" + createdDate +
                ", loan=" + loan +
                '}';
    }
}
