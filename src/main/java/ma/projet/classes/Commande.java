package ma.projet.classes;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@NamedQueries({@NamedQuery(
        name = "findBetweenDate",
        query = "from Commande where date between :d1 and :d2"
)})
@NamedNativeQueries({@NamedNativeQuery(
        name = "findBetweenDateNative",
        query = "select * from Commande where date between :d1 and :d2",
        resultClass = Commande.class
)})
public class Commande {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(
            mappedBy = "commande",
            fetch = FetchType.LAZY
    )
    private List<LigneCommandeProduit> lignecommandeproduit;

    public Commande() {
    }

    public Commande(Date date) {
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<LigneCommandeProduit> getLignes() {
        return this.lignecommandeproduit;
    }

    public void setLignes(List<LigneCommandeProduit> lignes) {
        this.lignecommandeproduit = lignes;
    }

    public String toString() {
        return "Commande{id=" + this.id + ", date=" + this.date + '}';
    }
}
