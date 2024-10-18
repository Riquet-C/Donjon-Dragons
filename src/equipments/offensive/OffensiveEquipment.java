package equipments.offensive;

import interactable.Interactable;
import character.Personnage;
import play.GameDisplay;

/**
 * The OffensiveEquipment class serves as an abstract base class for all offensive equipment
 * in the game, providing common functionality for modifying a character's offensive capabilities.
 * It implements the Interactable interface, allowing interactions with characters.
 */
public abstract class OffensiveEquipment implements Interactable {

    private String type;
    private int attackLevel;
    private String name;

    /**
     * Returns a string representation of the OffensiveEquipment, indicating what weapon has been found.
     *
     * @return A description of the equipment found, including its type.
     */
    @Override
    public String toString() {
        return "Vous avez trouvé une arme !! Voyons voir ce que c'est... Il s'agit de : " + type;
    }

    /**
     * Modifies the offensive equipment of a character if the new weapon is stronger than the current one.
     * If the character does not have any offensive equipment, it will equip the new weapon.
     *
     * @param character The character whose offensive equipment is being modified.
     * @param newWeapon The new OffensiveEquipment to be equipped.
     */
    protected void modifyOffensiveEquipment(Personnage character, OffensiveEquipment newWeapon) {
        if (character.getOffensiveEquipment() == null || character.getOffensiveEquipment().getAttackLevel() < getAttackLevel()) {
            character.setOffensiveEquipment(newWeapon);
            character.setAttackForce(getAttackLevel() + character.getAttackForce());
            GameDisplay.EQUIPMENTS_NEW.display(character.getOffensiveEquipment().getName(), character.getAttackForce());
        } else {
            GameDisplay.EQUIPMENTS_NOBETTER.display();
        }
    }


    // Setter & Getter

    /**
     * Sets the type of the offensive equipment.
     *
     * @param type The type of the equipment.
     */
    protected void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the attack level of the offensive equipment.
     *
     * @return The attack level of the equipment.
     */
    public int getAttackLevel() {
        return attackLevel;
    }

    /**
     * Sets the attack level of the offensive equipment.
     *
     * @param attackLevel The attack level to set.
     */
    protected void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    /**
     * Gets the name of the offensive equipment.
     *
     * @return The name of the equipment.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the offensive equipment.
     *
     * @param name The name to set for the equipment.
     */
    public void setName(String name) {
        this.name = name;
    }

}
