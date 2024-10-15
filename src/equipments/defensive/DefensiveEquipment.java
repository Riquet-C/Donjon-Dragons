package equipments.defensive;

/**
 * Abstract class representing defensive equipment in the game.
 * <p>
 * This class defines common attributes and behaviors for all types of defensive equipment.
 * It includes properties such as the type, defense level, and name of the equipment.
 * Additionally, it provides a method to display the equipment's details.
 * </p>
 */
public abstract class DefensiveEquipment {
    private String type;
    private int defenseLevel;
    private String name;

    // Color attributes for text formatting
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Returns a string representation of the defensive equipment, including its name, type, and defense level.
     *
     * @return A formatted string showing the equipment details.
     */
    @Override
    public String toString() {
        return ANSI_PURPLE + "Defensive Equipment: " + ANSI_RESET +
                "\nname: " + name + "\n" +
                "type: " + type + "\n" +
                "defense level: +" + defenseLevel;
    }

    // Setters & Getters

    /**
     * Sets the type of the defensive equipment.
     *
     * @param type The type of the equipment (e.g., "Shield").
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the defense level of the defensive equipment.
     *
     * @param defenseLevel The defense level, indicating how much protection the equipment provides.
     */
    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    /**
     * Returns the name of the defensive equipment.
     *
     * @return The name of the equipment.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the defensive equipment.
     *
     * @param name The name to be assigned to the equipment.
     */
    public void setName(String name) {
        this.name = name;
    }
}
