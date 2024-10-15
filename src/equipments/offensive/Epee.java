package equipments.offensive;

import character.Character;
import play.GameMenu;
import play.Menu;

import java.util.Objects;

/**
 * The Epee class represents a specific type of offensive equipment in the game.
 * It extends the OffensiveEquipment class and provides functionality to equip
 * the weapon to characters, specifically warriors.
 */
public class Epee extends OffensiveEquipment {

    /**
     * Constructs an Epee object, initializing its type, name,
     * and attack level.
     */
    public Epee() {
        this.setType("Arme");
        this.setName("Epee");
        this.setAttackLevel(5);
    }

    /**
     * Allows a character to interact with the Epee. If the character
     * is a warrior, they can equip the Epee; otherwise, a message is displayed
     * indicating that the character cannot equip this weapon.
     *
     * @param character The character interacting with the Epee.
     * @param menu The menu used for displaying game messages.
     */
    @Override
    public void interact(Character character, Menu menu) {
        GameMenu.EQUIPMENTS_FIND.display(this.getName());
        if (Objects.equals(character.getType(), "Guerrier")) {
            modifyOffensiveEquipment(character, this);
        } else {
            GameMenu.EQUIPMENTS_NOTAUTHORIZE.display();
        }
    }

}
