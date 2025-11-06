package ma.projet.classes;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LigneCommandeProduitPK implements Serializable {
    @Column(
            name = "commande_id"
    )
    private int commande;
    @Column(
            name = "produit_id"
    )
    private int produit;

    public int getCommande() {
        return this.commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }

    public int getProduit() {
        return this.produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }
}
