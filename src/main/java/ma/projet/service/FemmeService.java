package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class FemmeService implements IDao<Femme> {

    @Override
    public boolean create(Femme o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally{
            if (session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean delete(Femme o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally{
            if (session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean update(Femme o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally{
            if (session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public Femme getById(int id) {
        Session session = null;
        Transaction tx = null;
        Femme femme = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femme = (Femme) session.get(Femme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return femme;
    }

    @Override
    public List<Femme> getAll() {
        Session session = null;
        Transaction tx = null;
        List<Femme> femmes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery("from Femme").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return femmes;
    }

    public int getNombreEnfantsEntreDates(Femme femme, Date date1, Date date2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int total = 0;
        try {
            Number result = (Number) session.createNativeQuery(
                            "SELECT SUM(nbrEnfant) FROM mariages " +
                                    "WHERE femme = :idFemme AND dateDebut BETWEEN :date1 AND :date2")
                    .setParameter("idFemme", femme.getId())
                    .setParameter("date1", date1)
                    .setParameter("date2", date2)
                    .getSingleResult();

            if (result != null) total = result.intValue();
        } finally {
            session.close();
        }
        return total;
    }






    public List<Femme> getFemmesMarieesDeuxFoisOuPlus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Femme> result = null;

        try {
            tx = session.beginTransaction();
            String d = "select f from Femme f join f.mariages m group by f having count(m) >= 2";
            result = session.createQuery(d).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }




}