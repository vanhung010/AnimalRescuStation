package project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import project.entity.Staff;
import project.util.HibernateUtil;

import java.util.List;

public class StaffDao {

    //Thêm nhân viên
    public void save(Staff staff){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(staff);

            transaction.commit();

            System.out.println("Thêm nhân viên thành công");
        }
        catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //danh sach tất cả nhân viên
    public List<Staff>  getAllStaff(){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query<Staff> hql = session.createQuery("select distinct s from Staff s left join fetch s.missions");
            return hql.list();
        }
    }
}
