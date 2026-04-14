package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import project.entity.Reporter;
import project.util.HibernateUtil;

public class ReporterDao {

    //thêm người báo cuộc cứu hộ
    public void save(Reporter reporter){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(reporter);
            transaction.commit();
        }
        catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //lấy người cứu hộ bởi tên
    public Reporter getReporterByName(String name){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            Query<Reporter> hql = session.createQuery("FROM Reporter WHERE LOWER(fullName) LIKE LOWER(:name)", Reporter.class);
            hql.setParameter("name", name);

            return hql.uniqueResultOptional().orElse(null);
        }
    }
}
