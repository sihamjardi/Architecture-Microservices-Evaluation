package ma.projet.beans;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "mariages")

public class Mariage {
    @EmbeddedId
    private MariagePK pk;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    private Date dateFin;

    private int nbrEnfant;

    @ManyToOne
    @JoinColumn(name = "homme", insertable = false, updatable = false)
    private Homme homme;
    @ManyToOne
    @JoinColumn(name = "femme", insertable = false, updatable = false)
    private Femme femme;

    public Mariage() {
        pk = new MariagePK();
    }

    public Mariage(Date dateDebut, Date dateFin, int nbrEnfant, Homme homme, Femme femme) {
        pk = new MariagePK();
        this.pk.setHomme(homme.getId());
        this.pk.setFemme(femme.getId());
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        this.homme = homme;
        this.femme = femme;
    }

    public MariagePK getPk() {
        return pk;
    }

    public void setPk(MariagePK pk) {
        this.pk = pk;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

}