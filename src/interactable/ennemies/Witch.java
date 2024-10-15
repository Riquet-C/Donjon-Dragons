package interactable.ennemies;


/**
 * The Witch class represents a specific type of enemy in the game.
 * It extends the Ennemies class, providing specific attributes for a Witch enemy,
 * including its name, attack power, and life points.
 */
public class Witch extends Ennemies {

    /**
     * Constructs a new Witch instance with predefined attributes.
     * The Dragon has a name of "Sorcier", an attack power
     * and life points.
     */
    public Witch() {
        super("Sorcier", 2, 20);
    }
}
