package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HommeService implements IDao<Homme> {

    @Override
    public boolean create(Homme o) {
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
    public boolean delete(Homme o) {
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
    public boolean update(Homme o) {
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
    public Homme getById(int id) {
        Session session = null;
        Transaction tx = null;
        Homme homme = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            homme = (Homme) session.get(Homme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return homme;
    }

    @Override
    public List<Homme> getAll() {
        Session session = null;
        Transaction tx = null;
        List<Homme> hommes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            hommes = session.createQuery("from Homme").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally{
            if (session != null)
                session.close();
        }
        return hommes;
    }

    public List<Femme> getEpousesEntreDates(Homme homme, Date date1, Date date2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Femme> epouses = session.createQuery(
                        "select m.femme from Mariage m " +
                                "where m.homme = :homme and m.dateDebut between :date1 and :date2")
                .setParameter("homme", homme)
                .setParameter("date1", date1)
                .setParameter("date2", date2)
                .list();
        return epouses;
    }


    public List<Mariage> getMariagesParHomme(Homme h) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mariage> mariages = null;
        try {
            mariages = session.createQuery(
                            "FROM Mariage m WHERE m.homme = :h",
                            Mariage.class)
                    .setParameter("h", h)
                    .getResultList();
        } finally {
            session.close();
        }
        return mariages;
    }


    public void afficherMariages(Homme h) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Mariage> mariages = getMariagesParHomme(h);

        System.out.println("Nom: " + h.getNom() + " " + h.getPrenom());

        System.out.println("Mariages en cours:");
        int count = 1;
        for (Mariage m : mariages) {
            if (m.getDateFin() == null) {
                System.out.println(count + ". " + m.getFemme().getNom() + " " + m.getFemme().getPrenom());
                System.out.println("Date Début: " + sdf.format(m.getDateDebut()));
                System.out.println("Nombre Enfants: " + m.getNbrEnfant());
                count++;
            }
        }

        System.out.println("Mariages échoués:");
        count = 1;
        for (Mariage m : mariages) {
            if (m.getDateFin() != null) {
                System.out.println(count + ". " + m.getFemme().getNom() + " " + m.getFemme().getPrenom());
                System.out.println("Date Début: " +sdf.format(m.getDateDebut()));
                System.out.println("Date Fin: " + sdf.format(m.getDateFin()));
                System.out.println("Nombre Enfants: " + m.getNbrEnfant());
                count++;
            }
        }
    }


}