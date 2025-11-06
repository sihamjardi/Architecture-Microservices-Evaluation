//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ma.projet.test;

import java.text.SimpleDateFormat;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

public class Teste {
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ProjetService ps = new ProjetService();
            TacheService ts = new TacheService();
            EmployeService es = new EmployeService();
            EmployeTacheService ets = new EmployeTacheService();
            Employe emp = new Employe();
            emp.setNom("JARDI");
            emp.setPrenom("Siham");
            es.create(emp);
            Projet projet = new Projet();
            projet.setNom("Gestion de stock");
            projet.setDateDebut(sdf.parse("2/03/2016"));
            projet.setChefProjet(emp);
            ps.create(projet);
            Tache t1 = new Tache("Analyse", (double)1200.0F, projet);
            Tache t2 = new Tache("Conception", (double)1500.0F, projet);
            Tache t3 = new Tache("Développement", (double)3000.0F, projet);
            ts.create(t1);
            ts.create(t2);
            ts.create(t3);
            ets.create(new EmployeTache(sdf.parse("12/03/2016"), sdf.parse("2/03/2016"), emp, t1));
            ets.create(new EmployeTache(sdf.parse("10/04/2016"), sdf.parse("3/04/2016"), emp, t2));
            ets.create(new EmployeTache(sdf.parse("10/07/2016"), sdf.parse("9/07/2016"), emp, t3));
            System.out.println("Projet : " + projet.getId() + "    Nom : " + projet.getNom() + "    Date début : " + (new SimpleDateFormat("dd MMMM yyyy")).format(projet.getDateDebut()));
            System.out.println("Liste des tâches :");
            System.out.printf("%-4s %-15s %-18s %-18s\n", "Num", "Nom", "Date Début Réelle", "Date Fin Réelle");

            for(EmployeTache et : ps.getTachesRealisedWithDatesByProjet(projet.getId())) {
                Tache t = et.getTache();
                String debut = sdf.format(et.getDateDebutReelle());
                String fin = sdf.format(et.getDateFinReelle());
                System.out.printf("%-4d %-15s %-18s %-18s\n", t.getId(), t.getNom(), debut, fin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
