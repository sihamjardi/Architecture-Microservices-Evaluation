package ma.projet.service;

import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeTacheService implements IDao<EmployeTache> {
    public boolean create(EmployeTache o) {
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

    public boolean delete(EmployeTache o) {
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

    public boolean update(EmployeTache o) {
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

    public EmployeTache getById(int id) {
        Session session = null;
        Transaction tx = null;
        EmployeTache employetache = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employetache = (EmployeTache)session.get(EmployeTache.class, id);
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

        return employetache;
    }

    public List<EmployeTache> getAll() {
        Session session = null;
        Transaction tx = null;
        List<EmployeTache> employetaches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employetaches = session.createQuery("from EmployeTache ").list();
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

        return employetaches;
    }

    public List<EmployeTache> getTachesRealisedWithDatesByProjet(int idProjet) {
        Session session = null;
        List<EmployeTache> result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createNamedQuery("EmployeTache.findByProjetWithDates", EmployeTache.class)
                    .setParameter("pid", idProjet) // correspond exactement au :pid dans la NamedQuery
                    .list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

}
