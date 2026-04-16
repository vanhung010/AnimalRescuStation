package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.entity.MedicalRecord;
import project.util.HibernateUtil;

public class MedicalRecordDao {

    public void save(MedicalRecord medicalRecord){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(medicalRecord);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
