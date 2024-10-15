package character;

import equipments.defensive.Shield;

/**
 * The Warriors class represents a specific type of character in the game,
 * which is a warrior. It extends the Character class and initializes
 * specific attributes for a warrior character.
 */
public class Warriors extends Character {

    /**
     * Constructs a Warrior character with a specified name.
     * Initializes the warrior's life points, defensive equipment,
     * and attack force.
     *
     * @param name The name of the warrior.
     */
    public Warriors(String name) {
        super(name, "Guerrier");
        this.setLifePoints(10);
        this.setDefensiveEquipment(new Shield());
        this.setAttackForce(10 + (getOffensiveEquipment() != null ? getOffensiveEquipment().getAttackLevel() : 0));
    }
}
