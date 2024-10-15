package interactable.ennemies;
/**
 * The Goblin class represents a specific type of enemy in the game.
 * It extends the Ennemies class, providing specific attributes for a Goblin enemy,
 * including its name, attack power, and life points.
 */
public class Goblin extends Ennemies {

    /**
     * Constructs a new Goblin instance with predefined attributes.
     * The Goblin has a name of "Goblin", an attack power
     * and life points.
     */
    public Goblin() {
        super("Gobelin", 1, 20);
    }
}
