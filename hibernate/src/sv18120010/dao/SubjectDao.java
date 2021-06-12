package sv18120010.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sv18120010.Current.Current;
import sv18120010.connect.connect;
import sv18120010.hibernate.Classroom;
import sv18120010.hibernate.Course;
import sv18120010.hibernate.DKHP;
import sv18120010.hibernate.Subject;

import java.sql.Statement;
import java.util.List;

public class SubjectDao {
    private static Session session = connect.session;
    public static List<Subject> getAllSubject() {
        List<Subject> subjects = null;
        try {
            final String hql = "select st from Subject st";
            Query query = session.createQuery(hql);
            subjects = query.list();
        } catch (HibernateException e) {
            System.out.println("fail");
        }
        return subjects;
    }

    public static List<Course> getAllCourse() {
        List<Course> courses  = null;
        try {
            final String hql = "select st from Course st";
            Query query = session.createQuery(hql);
            courses = query.list();
        } catch (HibernateException e) {
            System.out.println("fail");
        }
        return courses;
    }

    public static List<DKHP> dkhps(){
        List<DKHP> dkhps = null;
        try {
            final String hql = "select dkhp from DKHP dkhp";
            Query query = session.createQuery(hql);
            dkhps = query.list();
        } catch (HibernateException e) {
            System.out.println("fail");
        }
        return dkhps;
    }

    public static boolean isDKHP(String MaHP, String idStudent){
        List<DKHP> dkhps = dkhps();
        for (DKHP item: dkhps){
            if (Current.currentSemester.getIdSemester().equals(item.getIdSemester()))
            if (MaHP.equals(item.getIdCourse()) && idStudent.equals(item.getIdStudent()))
                return false;
        }
        return true;
    }

    public static boolean isLsDKHP(String MaHP, String idStudent){
        List<DKHP> dkhps = dkhps();
        for (DKHP item: dkhps){
            if (Current.currentSemester.getIdSemester().equals(item.getIdSemester()))
                if (MaHP.equals(item.getIdCourse()) && idStudent.equals(item.getIdStudent()))
                    return true;
        }
        return false;
    }

    public static int total_HP(String idStudent){
        List<DKHP> dkhps = dkhps();
        int t=0;
        for (DKHP item: dkhps){
            if (idStudent.equals(item.getIdStudent()) && Current.currentSemester.getIdSemester().equals(item.getIdSemester()))
                t++;
        }
        return t;
    }

    public static void addDKHP(DKHP dkhp, String idClass){
        session.saveOrUpdate(dkhp);
        setClass(1, idClass);
    }

    public static DKHP getDKHP(String idDKHP){ return session.load(DKHP.class, idDKHP); }

    public static void subDKHP(DKHP dkhp,String idClass){
        session.saveOrUpdate(dkhp);
        setClass(-1, idClass);
    }

    public static void setClass(int i, String idClassroom){
        Classroom classroom = session.load(Classroom.class, idClassroom);
        classroom.setBoy(classroom.getBoy()+i);
        session.saveOrUpdate(classroom);
    }
}
