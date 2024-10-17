package character;

import equipments.defensive.Philtre;

/**
 * The Wizards class represents a specific type of character in the game,
 * which is a wizard. It extends the Character class and initializes
 * specific attributes for a wizard character.
 */
public class Wizards extends Personnage {

    /**
     * Constructs a Wizard character with a specified name.
     * Initializes the wizard's life points, defensive equipment,
     * and attack force.
     *
     * @param name The name of the wizard.
     */
    public Wizards(String name) {
        super(name, "Magicien");
        this.setLifePoints(6);
        this.setDefensiveEquipment(new Philtre());
        this.setAttackForce(15 + (getOffensiveEquipment() != null ? getOffensiveEquipment().getAttackLevel() : 0));
    }
}
