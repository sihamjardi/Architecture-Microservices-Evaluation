package ma.projet.classes;

import jakarta.persistence.*;

@Entity
public class LigneCommandeProduit {
    @EmbeddedId
    private LigneCommandeProduitPK pK = new LigneCommandeProduitPK();
    private int quantite;
    @ManyToOne
    @JoinColumn(
            name = "commande_id",
            insertable = false,
            updatable = false
    )
    private Commande commande;
    @ManyToOne
    @JoinColumn(
            name = "produit_id",
            insertable = false,
            updatable = false
    )
    private Produit produit;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(int quantite, Commande commande, Produit produit) {
        this.pK.setCommande(commande.getId());
        this.pK.setProduit(produit.getId());
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }

    public LigneCommandeProduitPK getpK() {
        return this.pK;
    }

    public void setpK(LigneCommandeProduitPK pK) {
        this.pK = pK;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return this.commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return this.produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
