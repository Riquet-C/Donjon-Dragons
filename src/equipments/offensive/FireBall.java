package equipments.offensive;
import character.Character;
import play.GameMenu;
import play.Menu;

import java.util.Objects;

public class FireBall extends OffensiveEquipment {


    public FireBall() {
        this.setType("Sort");
        this.setName("Boule De Feu");
        this.setNiveauAttaque(7);
    }

    @Override
    public void interact(Character character, Menu menu) {
        menu.displayFindEquipmentOffensif(this);
        if (Objects.equals(character.getType(), "Magicien")) {
            modifyEquipmentOffensif(character, this, menu);
        } else {
            GameMenu.EQUIPMENTS_NOTAUTHORIZE.display();

        }
    }

}