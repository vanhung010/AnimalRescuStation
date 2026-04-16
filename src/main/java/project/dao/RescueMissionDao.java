package project.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.entity.RescueMission;
import project.util.HibernateUtil;

import java.util.List;

public class RescueMissionDao {

    public void save(RescueMission rescueMission){
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(rescueMission);
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
        }

    }

    public List<RescueMission> getAllRescueMission(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM RescueMission", RescueMission.class).getResultList();
        }
    }

    public RescueMission getRescueMissionById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(RescueMission.class, id);
        }
    }
}
