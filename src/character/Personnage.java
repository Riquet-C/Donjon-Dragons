package character;

import equipments.defensive.DefensiveEquipment;
import equipments.offensive.OffensiveEquipment;
import equipments.potion.Potions;
import play.GameDisplay;

import java.util.ArrayList;
import java.util.List;

/**
 * The Character class represents a player character in the game.
 * It contains attributes for the character's name, type, life points,
 * attack force, offensive and defensive equipment, and inventory of potions.
 * This class serves as an abstract base class for specific character types,
 * such as Warriors and Wizards.
 */
public abstract class Personnage {

    // Color attributes for console output
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    // Character attributes
    private final String name;
    private String type;
    private int lifePoints;
    private int attackForce;
    private OffensiveEquipment offensiveEquipment;

    public DefensiveEquipment getDefensiveEquipment() {
        return defensiveEquipment;
    }

    private DefensiveEquipment defensiveEquipment;
    private final List<Potions> inventory;

    /**
     * Constructs a Character with the specified name and type.
     *
     * @param name the name of the character
     * @param type the type of the character
     */
    protected Personnage(String name, String type) {
        this.name = name;
        this.type = type;
        this.inventory = new ArrayList<>();
    }

    /**
     * Returns a string representation of the character, including details
     * such as name, type, life points, attack force, and equipment.
     *
     * @return a formatted string containing character details
     */
    @Override
    public String toString() {
        return ANSI_PURPLE + "\n=== Détails du Personnage ===\n" + ANSI_RESET +
                "Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Niveau de vie :" + lifePoints + "\n" +
                "Force d'attaque: " + (attackForce + (offensiveEquipment != null ? offensiveEquipment.getAttackLevel() : 0)) + "\n" +
                ANSI_PURPLE + "\n--- Équipement Offensif ---\n" + ANSI_RESET +
                (offensiveEquipment != null ? offensiveEquipment.getName() + "\n" : "Pas d'arme") +
                ANSI_PURPLE + "\n--- Équipement Defensif ---\n" + ANSI_RESET +
                (defensiveEquipment != null ? defensiveEquipment.getName() + "\n" : "Pas d'équipement") +
                ANSI_PURPLE + "============================" + ANSI_RESET;
    }

    /**
     * Adds a potion to the character's inventory.
     *
     * @param potion the potion to be added
     */
    public void addPotion(Potions potion) {
        inventory.add(potion);
    }

    /**
     * Uses the first potion in the inventory to restore life points.
     * Displays a message if the inventory is empty.
     *
     */
    public void usePotion() {
        if (inventory.isEmpty()) {
            GameDisplay.EMPTY_INVENTORY.display();
            return;
        }
        setLifePoints(getLifePoints() + inventory.getFirst().getAddLife());
        GameDisplay.POTION_TAKE.display(inventory.getFirst().getName(), this.getLifePoints());
        inventory.removeFirst();
    }

    // Setter & Getter methods

    /**
     * Sets the name of the character.
     *
     * @param name the new name for the character
     * @return the updated name
     */
    public String setName(String name) {
        return name;
    }

    /**
     * Sets the type of the character.
     *
     * @param type the new type for the character
     * @return the updated type
     */
    public String setType(String type) {
        return this.type = type;
    }

    /**
     * Returns the name of the character.
     *
     * @return the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the character.
     *
     * @return the character's type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the defensive equipment for the character.
     *
     * @param defensiveEquipment the defensive equipment to be set
     */
    protected void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    /**
     * Returns the offensive equipment of the character.
     *
     * @return the character's offensive equipment
     */
    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    /**
     * Sets the offensive equipment for the character.
     *
     * @param offensiveEquipment the offensive equipment to be set
     */
    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    /**
     * Returns the current life points of the character.
     *
     * @return the character's life points
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Sets the life points of the character.
     *
     * @param lifePoints the new life points for the character
     */
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
     * Returns the attack force of the character.
     *
     * @return the character's attack force
     */
    public int getAttackForce() {
        return attackForce;
    }

    /**
     * Sets the attack force of the character.
     *
     * @param attackForce the new attack force for the character
     */
    public void setAttackForce(int attackForce) {
        this.attackForce = attackForce;
    }

}
