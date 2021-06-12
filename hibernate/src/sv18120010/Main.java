package sv18120010;

import sv18120010.App.App;
import sv18120010.Current.Current;
import sv18120010.connect.connect;
import sv18120010.dao.StudentDao;
import sv18120010.dao.SubjectDao;
import sv18120010.hibernate.Course;
import sv18120010.hibernate.DKHP;
import sv18120010.hibernate.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        connect con =new connect();
        con.connected();
        Current cur = new Current();
        cur.current();
        /*List<Student> rs = StudentDao.getAllStudent();
        for (Student item : rs){
            System.out.println(item.getSchoolYear());
        }
        Student student = StudentDao.getStudent("1801");
        student.setSchoolYear(6);
        //StudentDao.updateStudent(student);
        System.out.println(student.getName());
        List<Student> rss = StudentDao.getAllStudent();
        for (Student item : rss){
            System.out.println(item.getSchoolYear());
        }*/
        /*
        SubjectDao.total_HP("1801");
        DKHP dkhp = SubjectDao.getDKHP("HK2-21-T1");
        dkhp.setIdSemester("HK2-21");
        System.out.println(dkhp.getIdDKHP() +"|"+dkhp.getIdStudent()+"|" +dkhp.getIdSemester());

        SubjectDao.addDKHP(dkhp, "A11");
        SubjectDao.total_HP("1801");
         */
        App a = new App();
        a.run();
    }
}
