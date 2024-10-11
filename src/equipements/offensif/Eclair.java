package equipements.offensif;

import personnage.Personnage;
import play.Menu;

import java.util.Objects;

public class Eclair extends EquipementOffensif {

    public Eclair() {
        this.setType("Sort");
        this.setName("Eclair");
        this.setNiveauAttaque(2);
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
