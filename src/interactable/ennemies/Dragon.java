package interactable.ennemies;

/**
 * The Dragon class represents a specific type of enemy in the game.
 * It extends the Ennemies class, providing specific attributes for a Dragon enemy,
 * including its name, attack power, and life points.
 */
public class Dragon extends Ennemies {

    /**
     * Constructs a new Dragon instance with predefined attributes.
     * The Dragon has a name of "Dragon", an attack power
     * and life points.
     */
    public Dragon() {
        super("Dragon", 4, 20); // Call the constructor of the superclass with specified values
    }
}