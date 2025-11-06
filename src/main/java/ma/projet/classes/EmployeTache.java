//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ma.projet.classes;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(
        name = "employetaches"
)
@NamedQueries({@NamedQuery(
        name = "EmployeTache.findTachesByEmploye",
        query = "select distinct et.tache from EmployeTache et where et.employe.id = :id"
), @NamedQuery(
        name = "EmployeTache.findTachesByProjet",
        query = "select distinct et.tache from EmployeTache et where et.tache.projet.id = :pid"
), @NamedQuery(
        name = "EmployeTache.findTachesBetweenDates",
        query = "select distinct et.tache from EmployeTache et where et.dateFinReelle between :d1 and :d2"
), @NamedQuery(
        name = "EmployeTache.findByProjetWithDates",
        query = "SELECT et FROM EmployeTache et WHERE et.tache.projet.id = :pid"
)})
public class EmployeTache {
    @EmbeddedId
    private EmployeTachePK pk;
    @Temporal(TemporalType.DATE)
    private Date dateDebutReelle;
    private Date dateFinReelle;
    @ManyToOne
    @JoinColumn(
            name = "employe",
            insertable = false,
            updatable = false
    )
    private Employe employe;
    @ManyToOne
    @JoinColumn(
            name = "tache",
            insertable = false,
            updatable = false
    )
    private Tache tache;

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle, Employe employe, Tache tache) {
        this.pk = new EmployeTachePK();
        this.pk.setEmploye(employe.getId());
        this.pk.setTache(tache.getId());
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
    }

    public EmployeTachePK getPk() {
        return this.pk;
    }

    public void setPk(EmployeTachePK pk) {
        this.pk = pk;
    }

    public Date getDateDebutReelle() {
        return this.dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return this.dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Employe getEmploye() {
        return this.employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return this.tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
}
