package sv18120010.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sv18120010.connect.connect;
import sv18120010.hibernate.AccountTeacher;
import sv18120010.hibernate.Teacher;
import sv18120010.util.hibernateUtil;

import java.sql.PreparedStatement;
import java.util.List;

public class TeacherDao {
    private static Session session = connect.session;
    public static List<Teacher> getAllTeacher() {
        List<Teacher> Teachers = null;
        try {
            final String hql = "select st from Teacher st";
            Query query = session.createQuery(hql);
            Teachers = query.list();
        } catch (HibernateException e) {
            System.out.println("fail");
        }
        return Teachers;
    }

    public static Teacher getTeacher(String idTeacher){
        return session.load(Teacher.class, idTeacher);
    }

    public static AccountTeacher getAccount(String idAccount){
        return session.load(AccountTeacher.class, idAccount);
    }

    public static List<AccountTeacher> getAllAccount() {
        List<AccountTeacher> accountTeachers = null;
        try {
            final String hql = "select st from AccountTeacher st";
            Query query = session.createQuery(hql);
            accountTeachers = query.list();
        } catch (HibernateException e) {
            System.out.println("fail");
        }
        return accountTeachers;
    }

    public static void updateTeacher(Teacher Teacher){
        session.saveOrUpdate(Teacher);
    }

    public static void updateAccount(AccountTeacher accountTeacher){
        session.saveOrUpdate(accountTeacher);
    }

}
