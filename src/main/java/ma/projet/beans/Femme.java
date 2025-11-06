
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name = "femmes")

@NamedNativeQuery(
        name = "Femme.nombreEnfantsEntreDates",
        query = "select SUM(nbrEnfant) from mariages " +
                "where femme = :idFemme and dateDebut >= :date1 and dateDebut <= :date2"
)

@NamedQuery(
        name = "Femme.marieesDeuxFoisOuPlus",
        query = "select f FROM Femme f join f.mariages m " +
                "group by f.id " +
                "having COUNT(m) >= 2"
)

public class Femme extends Personne{

    public Femme() {
    }
    @OneToMany(mappedBy = "femme")
    private List<Mariage> mariages;

    public Femme(String nom, String prenom, String telephone, String adresse, Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }

}