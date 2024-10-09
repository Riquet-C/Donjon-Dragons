package equipements.defensif;

abstract public class EquipementDefensif {
    private String type;
    private int niveauDefence;
    private String name;

    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";


    // toString
    public String toString() {
        return ANSI_PURPLE + "Equipement Offensif: " + ANSI_RESET +
                "\nname: " + name + "\n" +
                "type: " + type + "\n" +
                "niveau de défence: +" + niveauDefence;
    }

    // Setter & Getter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getniveauDefence() {
        return niveauDefence;
    }

    public void setniveauDefence(int niveauDefence) {
        this.niveauDefence = niveauDefence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
