import model.Loan;
import model.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {

    private static EntityManagerFactory emf = Persistence.
            createEntityManagerFactory("isilPU");

    public static void main(String[] args) {
        createLoan();
        listData();
    }

    private static void createLoan(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Loan loan1 = new Loan(1, "Juan","Jose",200.0,null);
        em.persist(loan1);
        em.persist(new Payment(1,100.0, LocalDate.of(2014,10,1), loan1));
        em.getTransaction().commit();
        em.close();
    }

    private static void listData(){
        EntityManager em = emf.createEntityManager();
        Loan currentLoan = em.find(Loan.class, 1);
        System.out.println("currentLoan = " + currentLoan);
        List<Payment> payments = currentLoan.getPaymentList();
        for (Payment payment: payments) {
            System.out.println(" Payment = " + payment);
        }
        em.close();
    }

}
