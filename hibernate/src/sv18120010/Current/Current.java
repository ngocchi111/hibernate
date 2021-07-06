package sv18120010.Current;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sv18120010.connect.connect;
import sv18120010.hibernate.Semester;

import java.util.List;

public class Current {
    public static Semester currentSemester;
    private static Session session = connect.session;

    public void setSemester(String S){
            Semester semester = null;

            try {
                //final String hql = "select st.idSemester" + "'" + "HK2-21" + "'"+ " from Semester st";
                //Query query = session.createQuery(hql);
                //List<Semester> list = query.list();
                //semester = list.get(0);
                semester = session.load(Semester.class, S);
            } catch (HibernateException e) {
                System.out.println("fail");
            }
            currentSemester=semester;
        }


    public void current(){
        setSemester("HK2-21");
    }
}
