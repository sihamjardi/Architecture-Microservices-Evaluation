
package ma.projet.service;

import java.util.List;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LigneCommandeService implements IDao<LigneCommandeProduit> {
    public boolean create(LigneCommandeProduit o) {
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

    public boolean delete(LigneCommandeProduit o) {
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

    public boolean update(LigneCommandeProduit o) {
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

    public LigneCommandeProduit getById(int id) {
        Session session = null;
        Transaction tx = null;
        LigneCommandeProduit lignecommandeProduit = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            lignecommandeProduit = (LigneCommandeProduit)session.get(LigneCommandeProduit.class, id);
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

        return lignecommandeProduit;
    }

    public List<LigneCommandeProduit> getAll() {
        Session session = null;
        Transaction tx = null;
        List<LigneCommandeProduit> lignecommandeProduits = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            lignecommandeProduits = session.createQuery("from LigneCommandeProduit").list();
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

        return lignecommandeProduits;
    }
}
