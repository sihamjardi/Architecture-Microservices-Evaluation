package ma.projet.service;

import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjetService implements IDao<Projet> {
    public boolean create(Projet o) {
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

    public boolean delete(Projet o) {
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

    public boolean update(Projet o) {
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

    public Projet getById(int id) {
        Session session = null;
        Transaction tx = null;
        Projet projet = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet)session.get(Projet.class, id);
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

        return projet;
    }

    public List<Projet> getAll() {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet").list();
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

        return projets;
    }

    public List<Projet> getProjetsByCategorie(int idCategorie) {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet p where p.categorie.id = :idCat").setParameter("idCat", idCategorie).list();
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

        return projets;
    }

    public List<Tache> getTachesPlanifiedByProjet(int projetId) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedQuery("Tache.findByProjet").setParameter("pid", projetId).list();
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

    public List<EmployeTache> getTachesRealisedWithDatesByProjet(int projetId) {
        List<EmployeTache> list = null;
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            // Hibernate 6 : createNamedQuery au lieu de getNamedQuery
            list = session.createNamedQuery(
                            "EmployeTache.findByProjetWithDates",
                            EmployeTache.class
                    )
                    .setParameter("pid", projetId)
                    .getResultList();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return list;
    }

}
