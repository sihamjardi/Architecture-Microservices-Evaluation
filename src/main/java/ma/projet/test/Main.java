package ma.projet.test;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;
import ma.projet.service.MariageService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        FemmeService femmeService = new FemmeService();
        HommeService hommeService = new HommeService();
        MariageService mariageService = new MariageService();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Femme[] femmes = {
                new Femme("Safi", "Salima", "0600000001", "Rabat, Maroc", sdf.parse("03/09/1990")),
                new Femme("Ali", "Amal", "0600000002", "Casablanca, Maroc", sdf.parse("12/06/1992")),
                new Femme("Alaoui", "Wafa", "0600000003", "Fès, Maroc", sdf.parse("04/11/2000")),
                new Femme("Rami", "Karima", "0600000004", "Marrakech, Maroc", sdf.parse("15/02/1989")),
                new Femme("Elhassani", "Nadia", "0600000005", "Tanger, Maroc", sdf.parse("22/07/1995")),
                new Femme("Bennani", "Yasmine", "0600000006", "Agadir, Maroc", sdf.parse("10/03/1993")),
                new Femme("Hamdani", "Sara", "0600000007", "Meknès, Maroc", sdf.parse("01/01/1998")),
                new Femme("Fassi", "Leila", "0600000008", "Oujda, Maroc", sdf.parse("09/09/1991")),
                new Femme("Zouiten", "Imane", "0600000009", "Kenitra, Maroc", sdf.parse("30/12/1996")),
                new Femme("Choukri", "Meriem", "0600000010", "Safi, Maroc", sdf.parse("17/05/1994"))
        };

        for (Femme f : femmes) {
            femmeService.create(f);
        }


        Homme[] hommes = {
                new Homme("Said", "Hassan", "0611111111", "Rabat, Maroc", sdf.parse("02/05/1985")),
                new Homme("Mohamed", "Youssef", "0611111112", "Casablanca, Maroc", sdf.parse("18/08/1988")),
                new Homme("Karim", "Amine", "0611111113", "Fès, Maroc", sdf.parse("25/12/1990")),
                new Homme("Rachid", "Sami", "0611111114", "Marrakech, Maroc", sdf.parse("09/11/1987")),
                new Homme("Adil", "Omar", "0611111115", "Tanger, Maroc", sdf.parse("14/03/1992"))
        };

        for (Homme h : hommes) {
            hommeService.create(h);
        }

        mariageService.create(new Mariage(sdf.parse("15/10/2025"), null, 4, hommes[0], femmes[0]));
        mariageService.create(new Mariage(sdf.parse("15/10/2025"), null, 2, hommes[0], femmes[1]));
        mariageService.create(new Mariage(sdf.parse("15/10/2025"), null, 3, hommes[0], femmes[2]));

        mariageService.create(new Mariage(sdf.parse("15/10/2025"), null, 1, hommes[1], femmes[3]));
        mariageService.create(new Mariage(sdf.parse("15/10/2025"), null, 1, hommes[1], femmes[4]));
        mariageService.create(new Mariage(sdf.parse("15/10/2025"), null, 1, hommes[1], femmes[5]));
        mariageService.create(new Mariage(sdf.parse("15/10/2025"), null, 1, hommes[1], femmes[6]));

        System.out.println("Liste des femmes :");
        femmeService.getAll().forEach(f -> System.out.println(f.getNom()));

        List<Femme> epousesH1 = hommeService.getEpousesEntreDates(hommes[0], new Date(0), new Date());
        System.out.println("\nÉpouses de " + hommes[0].getNom() + " :");
        epousesH1.forEach(f -> System.out.println(f.getNom()));

        int nbEnfantsF1 = femmeService.getNombreEnfantsEntreDates(femmes[0], new Date(0), new Date());
        System.out.println("\nNombre d'enfants de " + femmes[0].getNom() + " : " + nbEnfantsF1);

        List<Femme> femmesPlusieursMariages = femmeService.getFemmesMarieesDeuxFoisOuPlus();
        System.out.println("\nFemmes mariées deux fois ou plus :");
        femmesPlusieursMariages.forEach(f -> System.out.println(f.getNom()));

        long hommes4Femmes = mariageService.getHommesMarieesQuatreFemmesEntreDates(new Date(0), new Date());
        System.out.println("\nNombre d'hommes mariés à 4 femmes : " + hommes4Femmes);

        System.out.println("\nDétails des mariages de " + hommes[0].getNom() + " :");
        hommeService.afficherMariages(hommes[0]);
    }
}