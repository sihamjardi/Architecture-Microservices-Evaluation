//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ma.projet.classes;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(
        name = "employes"
)
public class Employe {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    @OneToMany(
            mappedBy = "employe",
            fetch = FetchType.EAGER
    )
    private List<Projet> projets;

    public Employe() {
    }

    public Employe(String nom, String prenom, String telephone, List<Projet> projets) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.projets = projets;
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

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Projet> getProjets() {
        return this.projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public String toString() {
        return "Employe{id=" + this.id + ", nom=" + this.nom + ", prenom=" + this.prenom + ", telephone=" + this.telephone + ", projets=" + this.projets + '}';
    }
}
