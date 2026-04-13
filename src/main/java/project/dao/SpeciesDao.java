package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import project.entity.Species;
import project.util.HibernateUtil;


import java.util.List;


public class SpeciesDao {

    //thêm 1 loài
    public void save(Species species){
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(species);
            transaction.commit();
            System.out.println("Lưu loài" + species.getSpeciesName() +" thành công");
        }
        catch(Exception e){
            if(transaction != null){
                transaction.rollback(); //nếu có lỗi thì rollback
            }
            e.printStackTrace();
        }
    }

    //lấy danh sách tất các loài
    public List<Species> getAllSpecies(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Species", Species.class).list();
        }
    }

    //Tìm kieems loài dựa vào tên
    public Species findSpeciesByName(String name1){
        Species result = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession() )/*tạo session*/{
            Transaction transaction1 = session.beginTransaction();
            String hql = "FROM Species WHERE speciesName = :name";

            Query<Species> query = session.createQuery(hql, Species.class);
            query.setParameter("name", name1);
            result = query.getSingleResult();
            return result;
        }

    }
}
