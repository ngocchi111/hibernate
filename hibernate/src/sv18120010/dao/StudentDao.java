package sv18120010.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sv18120010.connect.connect;
import sv18120010.hibernate.AccountStudent;
import sv18120010.hibernate.Student;
import sv18120010.util.hibernateUtil;

import java.sql.PreparedStatement;
import java.util.List;

public class StudentDao {
    private static Session session = connect.session;
    public static List<Student> getAllStudent() {
        List<Student> students = null;
        try {
            final String hql = "select st from Student st";
            Query query = session.createQuery(hql);
            students = query.list();
        } catch (HibernateException e) {
            System.out.println("fail");
        }
        return students;
    }

    public static Student getStudent(String idStudent){
        return session.load(Student.class, idStudent);
    }

    public static AccountStudent getAccount(String idAccount){
        return session.load(AccountStudent.class, idAccount);
    }

    public static List<AccountStudent> getAllAccount() {
        List<AccountStudent> accountStudents = null;
        try {
            final String hql = "select st from AccountStudent st";
            Query query = session.createQuery(hql);
            accountStudents = query.list();
        } catch (HibernateException e) {
            System.out.println("fail");
        }
        return accountStudents;
    }

    public static void updateStudent(Student student){
        session.saveOrUpdate(student);
    }

    public static void updateAccount(AccountStudent accountStudent){
        session.saveOrUpdate(accountStudent);
    }

}
