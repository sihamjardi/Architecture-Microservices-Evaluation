package ma.projet.service;

import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeService implements IDao<Employe> {
    public boolean create(Employe o) {
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

    public boolean delete(Employe o) {
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

    public boolean update(Employe o) {
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

    public Employe getById(int id) {
        Session session = null;
        Transaction tx = null;
        Employe employe = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe = (Employe)session.get(Employe.class, id);
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

        return employe;
    }

    public List<Employe> getAll() {
        Session session = null;
        Transaction tx = null;
        List<Employe> employes = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes = session.createQuery("from Employe").list();
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

        return employes;
    }

    public List<Tache> getTachesByEmploye(int employeId) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedQuery("EmployeTache.findTachesByEmploye").setParameter("id", employeId).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return taches;
    }

    public List<Projet> getProjetsByEmploye(int employeId) {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.getNamedQuery("Projet.findProjetsByEmploye").setParameter("id", employeId).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

        return projets;
    }
}
