package equipement;

abstract public class EquipementOffensif {

    private String type;
    private int niveauAttaque;
    private String name;

    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";


    public String toString() {
        return ANSI_PURPLE + "Equipement Offensif: " + ANSI_RESET +
                "\nname: " + name + "\n" +
                "type: " + type + "\n" +
                "niveau d'attaque: +" + niveauAttaque;
    }


    // Setter & Getter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNiveauAttaque() {
        return niveauAttaque;
    }

    public void setNiveauAttaque(int niveauAttaque) {
        this.niveauAttaque = niveauAttaque;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
