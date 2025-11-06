//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ma.projet.classes;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(
        name = "projets"
)
@NamedQuery(
        name = "Projet.findProjetsByEmploye",
        query = "from Projet p where p.employe.id = :id"
)
public class Projet {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @ManyToOne
    private Employe employe;
    @OneToMany(
            mappedBy = "projet",
            cascade = {CascadeType.ALL}
    )
    private List<Tache> taches;

    public Projet() {
    }

    public Projet(int id, String nom, Date dateDebut, Date dateFin, Employe employe, List<Tache> taches) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.employe = employe;
        this.taches = taches;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Employe getChefProjet() {
        return this.employe;
    }

    public void setChefProjet(Employe employe) {
        this.employe = employe;
    }

    public List<Tache> getTaches() {
        return this.taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }
}
