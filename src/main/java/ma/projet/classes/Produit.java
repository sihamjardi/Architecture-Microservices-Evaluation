package ma.projet.classes;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(
        name = "produits"
)
@NamedQuery(
        name = "Produit.findPrixSup100",
        query = "from Produit p where p.prix > 100"
)
public class Produit {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String reference;
    private float prix;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(
            mappedBy = "produit",
            fetch = FetchType.LAZY
    )
    private List<LigneCommandeProduit> lignesCommande;

    public Produit() {
    }

    public Produit(String reference, float prix) {
        this.reference = reference;
        this.prix = prix;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrix() {
        return this.prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<LigneCommandeProduit> getLignesCommande() {
        return this.lignesCommande;
    }

    public void setLignesCommande(List<LigneCommandeProduit> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }

    public String toString() {
        return "Produit{id=" + this.id + ", reference=" + this.reference + ", prix=" + this.prix + ", categorie=" + this.categorie + '}';
    }
}
