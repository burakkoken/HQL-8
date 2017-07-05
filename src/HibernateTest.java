import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Burak Köken on 5.7.2017.
 */
public class HibernateTest {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        String hql = "UPDATE Product AS P " +
                "SET P.name = :paramName, " +
                "P.price = :paramPrice " +
                "WHERE P.id = 1";
        Query query = session.createQuery(hql);
        query.setParameter("paramName", "iPhone");
        query.setParameter("paramPrice", 5000);
        query.executeUpdate();

        session.close();
        
    }
}
