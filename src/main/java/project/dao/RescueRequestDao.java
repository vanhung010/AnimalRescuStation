package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import project.entity.RescueRequest;
import project.util.HibernateUtil;

import java.util.List;

public class RescueRequestDao {

    //Thêm yêu cầu cứu hộ
    public void save(RescueRequest rescueRequest){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(rescueRequest);

            transaction.commit();

        }
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

    }

    //danh sách những yêu cầu cứu hộ
    public List<RescueRequest> getAllRescurequest(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM RescueRequest").list();
        }
    }
}
