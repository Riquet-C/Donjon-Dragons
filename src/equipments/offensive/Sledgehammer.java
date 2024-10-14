package equipments.offensive;
import character.Character;
import play.GameMenu;
import play.Menu;
import java.util.Objects;

public class Sledgehammer extends OffensiveEquipment {

    public Sledgehammer() {
        this.setType("Arme");
        this.setName("Massue");
        this.setNiveauAttaque(3);
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