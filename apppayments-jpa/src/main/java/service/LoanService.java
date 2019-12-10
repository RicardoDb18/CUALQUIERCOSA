package service;

import model.Loan;
import model.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LoanService {
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public LoanService(){
        emf = Persistence.createEntityManagerFactory("isilPU");
        manager = emf.createEntityManager();

    }
    public void create(Loan loan){
        manager.getTransaction().begin();
        manager.persist(loan);
        manager.getTransaction().commit();
    }

    public static List<Loan> findAll(){
        return (List<Loan>) manager.createQuery("FROM Loan").getResultList();
    }


    public void delete(Integer loanNumber){
        manager.getTransaction().begin();
        Loan loan = findOne(loanNumber);
        if (loanNumber != null){
            manager.remove(loan);
        }
        manager.getTransaction().commit();

    }
    public Loan findOne(Integer loanNumber){
        return manager.find(Loan.class, loanNumber);

    }

    public void Amortizacion(){

    }
}
