package equipments.offensive;

import character.Character;
import play.GameMenu;
import play.Menu;

import java.util.Objects;

/**
 * The FireBall class represents a specific type of offensive spell in the game.
 * It extends the OffensiveEquipment class and provides functionality to equip
 * the spell to characters, specifically wizards.
 */
public class FireBall extends OffensiveEquipment {

    /**
     * Constructs a FireBall object, initializing its type, name,
     * and attack level.
     */
    public FireBall() {
        this.setType("Sort");
        this.setName("Boule De Feu");
        this.setAttackLevel(7);
    }

    /**
     * Allows a character to interact with the FireBall. If the character
     * is a wizard, they can equip the FireBall; otherwise, a message is displayed
     * indicating that the character cannot equip this spell.
     *
     * @param character The character interacting with the FireBall.
     * @param menu The menu used for displaying game messages.
     */
    @Override
    public void interact(Character character, Menu menu) {
        GameMenu.EQUIPMENTS_FIND.display(this.getName());
        if (Objects.equals(character.getType(), "Magicien")) {
            modifyOffensiveEquipment(character, this);
        } else {
            GameMenu.EQUIPMENTS_NOTAUTHORIZE.display();
        }
    }

}
