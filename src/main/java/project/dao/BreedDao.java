package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.entity.Breed;
import project.util.HibernateUtil;

import java.util.List;

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

    //lấy danh sách tất cả giống
    public List<Breed> getAllBreed(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Breed", Breed.class).stream().toList();
        }
    }

    //lấy giống bởi id
    public Breed getBreedById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
           return session.get(Breed.class, id);
        }
    }
}
