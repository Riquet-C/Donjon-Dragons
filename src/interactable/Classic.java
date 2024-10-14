package interactable;
import character.Character;
import play.Menu;

public class Classic implements Interactable {

    public Classic() {
    }

    @Override
    public void interact(Character character, Menu menu) {
        System.out.println("Vous arrivez sur une clairière déserte, balayée par le vent. Rien ne semble s'y passer...");
        System.out.println("Le silence est inquiétant. Vous reprenez votre souffle avant de continuer.");
    }
}
