package sv18120010.dao;

import sv18120010.hibernate.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sv18120010.util.hibernateUtil;

import java.util.List;

public class StudentDao {
    public static List<Student> getAllStudent() {
        Session session = null;
        if (hibernateUtil.getSessionFactory()!=null)
            session = hibernateUtil.getSessionFactory().openSession();

        List<Student> students = null;
        try {
            final String hql = "select st from Student st";
            Query query = session.createQuery(hql);
            students = query.list();
        } catch (HibernateException e) {
            System.out.println("fail");
        }finally {
            session.close();
        }
        return students;
    }
}
