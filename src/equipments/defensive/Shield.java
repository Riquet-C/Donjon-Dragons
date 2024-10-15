package equipments.defensive;

/**
 * The Shield class represents a defensive equipment item in the game.
 * It extends the DefensiveEquipment class and provides a specific
 * type of defensive item that increases a character's defense level.
 */
public class Shield extends DefensiveEquipment {

    /**
     * Constructs a Shield with predefined attributes.
     * Sets the name, type, and defense level of the Shield.
     */
    public Shield() {
        this.setName("Bouclier");
        this.setType("Bouclier en acier");
        this.setDefenseLevel(2);
    }
}
