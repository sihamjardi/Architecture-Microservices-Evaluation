package ma.projet.service;

import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategorieService implements IDao<Categorie> {
    public boolean create(Categorie o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException var9) {
            if (tx != null) {
                tx.rollback();
            }

            etat = false;
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return etat;
    }

    public boolean delete(Categorie o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException var9) {
            if (tx != null) {
                tx.rollback();
            }

            etat = false;
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return etat;
    }

    public boolean update(Categorie o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException var9) {
            if (tx != null) {
                tx.rollback();
            }

            etat = false;
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return etat;
    }

    public Categorie getById(int id) {
        Session session = null;
        Transaction tx = null;
        Categorie categorie = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorie = (Categorie)session.get(Categorie.class, id);
            tx.commit();
        } catch (HibernateException var9) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return categorie;
    }

    public List<Categorie> getAll() {
        Session session = null;
        Transaction tx = null;
        List<Categorie> categories = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categories = session.createQuery("from Categorie").list();
            tx.commit();
        } catch (HibernateException var8) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return categories;
    }
}
