package ma.projet.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Properties props = new Properties();
            props.load(HibernateUtil.class.getClassLoader().getResourceAsStream("application.properties"));

            Configuration configuration = new Configuration();
            configuration.setProperties(props);

            configuration.addAnnotatedClass(ma.projet.classes.Produit.class);
            configuration.addAnnotatedClass(ma.projet.classes.Categorie.class);
            configuration.addAnnotatedClass(ma.projet.classes.Commande.class);
            configuration.addAnnotatedClass(ma.projet.classes.LigneCommandeProduit.class);
            configuration.addAnnotatedClass(ma.projet.classes.EmployeTache.class);
            configuration.addAnnotatedClass(ma.projet.classes.Employe.class);
            configuration.addAnnotatedClass(ma.projet.classes.Tache.class);
            configuration.addAnnotatedClass(ma.projet.classes.Projet.class);
            configuration.addAnnotatedClass(ma.projet.beans.Mariage.class);
            configuration.addAnnotatedClass(ma.projet.beans.Homme.class);
            configuration.addAnnotatedClass(ma.projet.beans.Femme.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (IOException ex) {
            throw new ExceptionInInitializerError("Impossible de charger application.properties: " + ex);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("SessionFactory initialisation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
