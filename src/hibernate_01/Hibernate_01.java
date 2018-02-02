package hibernate_01;

import com.Entidades.DetallesUsuario;
import org.hibernate.Session;

public class Hibernate_01 {

    public static void main(String[] args) {

        DetallesUsuario usuario = new DetallesUsuario();
        usuario.setNombre("-Nombre-");
        usuario.setApellidos("-Apellido-");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();

        // TODO code application logic here
    }

}
