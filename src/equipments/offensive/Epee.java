package equipments.offensive;

import character.Character;
import play.GameMenu;
import play.Menu;

import java.util.Objects;

public class Epee extends OffensiveEquipment {

    public Epee() {
        this.setType("Arme");
        this.setName("Epee");
        this.setNiveauAttaque(5);
    }

    @Override
    public void interact(Character character, Menu menu) {
        menu.displayFindEquipmentOffensif(this);
        if (Objects.equals(character.getType(), "Guerrier")) {
            modifyEquipmentOffensif(character, this, menu);
        } else {
            GameMenu.EQUIPMENTS_NOTAUTHORIZE.display();
        }
    }

}
