package sv18120010.connect;

import org.hibernate.Session;
import sv18120010.util.hibernateUtil;

public class connect {
    public static Session session = null;
    public void connected()
    {
        session = hibernateUtil.getSessionFactory().openSession();
    }
}
