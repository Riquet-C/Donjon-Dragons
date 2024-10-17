package equipments.offensive;

import character.Character;
import play.GameDisplay;
import play.Menu;

import java.util.Objects;

/**
 * The LightningBolt class represents a specific type of offensive spell in the game.
 * It extends the OffensiveEquipment class and provides functionality to equip
 * the spell to characters, specifically wizards.
 */
public class LightningBolt extends OffensiveEquipment {

    /**
     * Constructs a LightningBolt object, initializing its type, name,
     * and attack level.
     */
    public LightningBolt() {
        this.setType("Sort");
        this.setName("Eclair");
        this.setAttackLevel(2);
    }

    /**
     * Allows a character to interact with the LightningBolt. If the character
     * is a wizard, they can equip the LightningBolt; otherwise, a message is displayed
     * indicating that the character cannot equip this spell.
     *
     * @param character The character interacting with the LightningBolt.
     * @param menu The menu used for displaying game messages.
     */
    @Override
    public void interact(Character character, Menu menu) {
        GameDisplay.EQUIPMENTS_FIND.display(this.getName());
        if (Objects.equals(character.getType(), "Magicien")) {
            modifyOffensiveEquipment(character, this);
        } else {
            GameDisplay.EQUIPMENTS_NOTAUTHORIZE.display();
        }
    }

}
