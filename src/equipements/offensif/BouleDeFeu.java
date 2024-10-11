package equipements.offensif;
import personnage.Personnage;
import play.Menu;

import java.util.Objects;

public class BouleDeFeu extends EquipementOffensif {


    public BouleDeFeu() {
        this.setType("Sort");
        this.setName("Boule De Feu");
        this.setNiveauAttaque(7);
    }

    @Override
    public void interact(Personnage personnage, Menu menu) {
        menu.displayFindEquipmentOffensif(this);
        if (Objects.equals(personnage.getType(), "Magicien")) {
            modifyEquipmentOffensif(personnage, this, menu);
        } else {
            menu.displayNotAutorizeEquipmentOffensif();
        }
    }

}