package ma.projet.beans;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MariagePK implements Serializable {

    private int homme;
    private int femme;



    public MariagePK() {
    }

    public int getHomme() {
        return homme;
    }

    public void setHomme(int homme) {
        this.homme = homme;
    }

    public int getFemme() {
        return femme;
    }

    public void setFemme(int femme) {
        this.femme = femme;
    }

}