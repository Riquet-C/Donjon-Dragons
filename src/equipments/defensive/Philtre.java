package equipments.defensive;

/**
 * The Philtre class represents a defensive equipment item in the game.
 * It extends the DefensiveEquipment class and provides a specific
 * type of defensive item that increases a character's defense level.
 */
public class Philtre extends DefensiveEquipment {

    /**
     * Constructs a Philtre with predefined attributes.
     * Sets the name, type, and defense level of the Philtre.
     */
    public Philtre() {
        this.setName("Philtre de défence");
        this.setType("Philtre");
        this.setDefenseLevel(3);
    }
}
