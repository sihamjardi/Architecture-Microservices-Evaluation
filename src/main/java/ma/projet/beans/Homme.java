package ma.projet.beans;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table (name = "hommes")
@NamedQuery(
        name = "Homme.findEpousesEntreDates",
        query = "select m.femme from Mariage m " +
                "where m.homme = :homme " +
                "and m.dateDebut between :date1 and :date2"
)
public class Homme extends Personne {

    public Homme() {
    }

    public Homme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }


}