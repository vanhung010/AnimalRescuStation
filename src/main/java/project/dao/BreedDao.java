package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.entity.Breed;
import project.util.HibernateUtil;

public class BreedDao {

    //thêm giống
    public void addBreed(Breed breed){
       Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            session.save(breed);
            transaction.commit();
            System.out.println("Thêm thanhf công giống "+breed.getBreedName());
        }
        catch(Exception e){
            if (transaction != null){
                transaction.rollback();
            }

        }
    }
}
