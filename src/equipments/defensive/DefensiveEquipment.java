package equipments.defensive;

abstract public class DefensiveEquipment {
    private String type;
    private int defenseLevel;
    private String name;

    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";


    // toString
    public String toString() {
        return ANSI_PURPLE + "Equipement Offensif: " + ANSI_RESET +
                "\nname: " + name + "\n" +
                "type: " + type + "\n" +
                "niveau de défence: +" + defenseLevel;
    }

    // Setter & Getter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int niveauDefence) {
        this.defenseLevel = niveauDefence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
