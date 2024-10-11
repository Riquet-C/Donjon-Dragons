package equipements.potion;

import Case.*;
import personnage.Personnage;
import play.Menu;

public abstract class Potions implements Case {
    private final String type;
    private final String name;
    private final int ajoutVie;


    public Potions(String type, String name, int ajoutVie) {
        this.type = type;
        this.name = name;
        this.ajoutVie = ajoutVie;
    }


    @Override
    public void interact(Personnage personnage, Menu menu) {
        String choice = menu.displayChoicePotion();
        switch (choice) {
            case "1":
                personnage.setNiveauDeVie(personnage.getNiveauDeVie() + ajoutVie);
                menu.displayTakePotion(this, personnage);
                break;
            case "2":
                menu.displayRefusePotion();
                personnage.addPotion(this);
                break;
            default:
                menu.defaultInteract();
                this.interact(personnage, menu);
        }

    }

    public int getAjoutVie() {
        return ajoutVie;
    }
}
