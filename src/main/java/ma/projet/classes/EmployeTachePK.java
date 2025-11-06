package ma.projet.classes;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeTachePK implements Serializable {
    private int employe;
    private int tache;

    public int getEmploye() {
        return this.employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public int getTache() {
        return this.tache;
    }

    public void setTache(int tache) {
        this.tache = tache;
    }
}
