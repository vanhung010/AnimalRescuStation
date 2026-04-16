package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.entity.Vaccine;
import project.util.HibernateUtil;

import java.util.List;

public class VaccineDao {
    public void save(Vaccine vaccine){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(vaccine);

            transaction.commit();
        }
        catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public List<Vaccine> getAllVaccine(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Vaccine", Vaccine.class).getResultList();
        }
    }

    public Vaccine getVaccineById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Vaccine.class, id);
        }
    }
}
