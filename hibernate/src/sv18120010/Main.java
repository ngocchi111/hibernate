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
        App a = new App();
        a.run();
    }
}
