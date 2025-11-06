package ma.projet.classes;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(
        name = "taches"
)
@NamedQueries({@NamedQuery(
        name = "Tache.findPrixSup1000",
        query = "FROM Tache t WHERE t.prix > 1000"
), @NamedQuery(
        name = "Tache.findBetweenDates",
        query = "FROM Tache t WHERE t.dateDebut BETWEEN :start AND :end"
)})
public class Tache {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    private Date dateFin;
    private double prix;
    @ManyToOne
    private Projet projet;
    @OneToMany(
            mappedBy = "tache",
            cascade = {CascadeType.ALL}
    )
    private List<EmployeTache> employeTaches;

    public Tache() {
    }

    public Tache(String nom, double prix, Projet projet) {
        this.nom = nom;
        this.prix = prix;
        this.projet = projet;
    }

    public Tache(String nom, Date dateDebut, Date dateFin, double prix, List<EmployeTache> employeTaches) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.employeTaches = employeTaches;
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

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Projet getProjet() {
        return this.projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<EmployeTache> getEmployeTaches() {
        return this.employeTaches;
    }

    public void setEmployeTaches(List<EmployeTache> employeTaches) {
        this.employeTaches = employeTaches;
    }
}
