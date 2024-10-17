package equipments.offensive;

import character.Character;
import play.GameDisplay;
import play.Menu;

import java.util.Objects;

/**
 * The Sledgehammer class represents a type of offensive equipment in the game, specifically a heavy weapon.
 * It extends the OffensiveEquipment class and provides the functionality to interact with characters,
 * allowing only characters of type "Guerrier" to equip it.
 */
public class Sledgehammer extends OffensiveEquipment {

    /**
     * Constructs a new Sledgehammer instance, setting its type, name, and attack level.
     */
    public Sledgehammer() {
        this.setType("Arme");
        this.setName("Massue");
        this.setAttackLevel(3);
    }

    /**
     * Allows the character to interact with the Sledgehammer.
     * If the character is of type "Guerrier", the weapon is equipped; otherwise, an error message is displayed.
     *
     * @param character The character attempting to interact with the Sledgehammer.
     * @param menu The menu context in which the interaction occurs.
     */
    @Override
    public void interact(Character character, Menu menu) {
        GameDisplay.EQUIPMENTS_FIND.display(this.getName());
        if (Objects.equals(character.getType(), "Guerrier")) {
            modifyOffensiveEquipment(character, this);
        } else {
            GameDisplay.EQUIPMENTS_NOTAUTHORIZE.display();
        }
    }
}
