package hibernate_01;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author USER
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            Configuration configuration = new Configuration();
            configuration.configure("Hibernate.cfg.xml");
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry) serviceRegistry);
            return sessionFactory;

        } catch (Throwable e) {

            System.out.println("La creacion del SessionFacatory ha fallado " + e);
            throw new ExceptionInInitializerError();

        }

    }

    /**
     * @return the sessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
