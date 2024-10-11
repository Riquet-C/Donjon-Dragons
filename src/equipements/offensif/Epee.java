package equipements.offensif;

import personnage.Personnage;
import play.Menu;

import java.util.Objects;

public class Epee extends EquipementOffensif {

    public Epee() {
        this.setType("Arme");
        this.setName("Epee");
        this.setNiveauAttaque(5);
    }

    @Override
    public void interact(Personnage personnage, Menu menu) {
        menu.displayFindEquipmentOffensif(this);
        if (Objects.equals(personnage.getType(), "Guerrier")) {
            modifyEquipmentOffensif(personnage, this, menu);
        } else {
            menu.displayNotAutorizeEquipmentOffensif();
        }
    }

}
