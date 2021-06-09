package sv18120010;

import sv18120010.dao.StudentDao;
import sv18120010.hibernate.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> rs = StudentDao.getAllStudent();
        for (Student item : rs){
            System.out.println(item.toString());
        }
    }
}
