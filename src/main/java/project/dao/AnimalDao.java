package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.entity.Animal;
import project.util.HibernateUtil;

import java.util.List;

public class AnimalDao {
    //thêm động vật
    public void save(Animal animal){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(animal);
            transaction.commit();
            System.out.println("Thêm thành công động vật " + animal.getName());
        }
        catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public Animal getAnimalById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Animal.class, id);
        }
    }

    //Lấy danh sách tất cả động vật
    public List<Animal> getAllAnimal(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Animal", Animal.class).stream().toList();
        }
    }
}
