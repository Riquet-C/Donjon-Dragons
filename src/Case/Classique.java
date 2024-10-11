package Case;
import personnage.Personnage;
import play.Menu;

public class Classique implements Case {

    public Classique() {
    }

    @Override
    public void interact(Personnage personnage, Menu menu) {
        System.out.println("Vous arrivez sur une clairière déserte, balayée par le vent. Rien ne semble s'y passer...");
        System.out.println("Le silence est inquiétant. Vous reprenez votre souffle avant de continuer.");
    }
}
