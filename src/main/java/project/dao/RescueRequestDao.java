package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.entity.RescueRequest;
import project.util.HibernateUtil;

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
}
