package service;

import model.Loan;
import model.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PaymentService {
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public PaymentService(){
        emf = Persistence.createEntityManagerFactory("isilPU");
        manager = emf.createEntityManager();

    }
    public void create(Payment payment){
        manager.getTransaction().begin();
        manager.persist(payment);
        manager.getTransaction().commit();
    }

    public static List<Payment> findAll(){
        return (List<Payment>) manager.createQuery("FROM Payment").getResultList();
    }
    public void delete(Integer paymentId){
        manager.getTransaction().begin();
        Payment payment = findOne(paymentId);
        if (paymentId != null){
            manager.remove(payment);
        }
        manager.getTransaction().commit();

    }
    public Payment findOne(Integer paymentId){
        return manager.find(Payment.class, paymentId);


    }
}
