package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import project.entity.Adopter;
import project.util.HibernateUtil;

import java.util.List;

public class AdopterDao {

    //thêm người nhận nuôi
    public void save(Adopter adopter){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            session.save(adopter);

            transaction.commit();

            System.out.println("thêm thành công người nhận nuôi " + adopter.getFullName());

        }
        catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    //lấy người nhận nuooi bởi id
    public Adopter getAdopterById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Adopter.class, id);
        }
    }

    //lấy danh sách tất cả người nhận nuôi
    public List<Adopter> getAllAdopter(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Adopter> hql = session.createQuery("FROM Adopter", Adopter.class);
            return  hql.getResultList();
        }
    }

}
