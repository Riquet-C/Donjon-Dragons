import java.util.Objects;

public class Personnage {

    // attributs
    private String name;
    private String type;
    private int niveauDeVie;
    private int forceDattaque;

    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;

    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";


    public Personnage() {
        this("Toto");
    }

    public Personnage(String name) {
        this(name, "Guerrier");
    }

    public Personnage(String name, String type) {
        this.name = name;
        this.type = type;

        if (type.equalsIgnoreCase("Guerrier")) {
            this.niveauDeVie = 10;
            this.forceDattaque = 10;
            this.equipementOffensif = new EquipementOffensif("Arme", "Massue", 3);
            this.equipementDefensif = new EquipementDefensif("Bouclier", 2, "Bouclier d'acier");
        }
        if (type.equalsIgnoreCase("Magicien")) {
            this.niveauDeVie = 6;
            this.forceDattaque = 15;
            this.equipementOffensif = new EquipementOffensif("Sort", "Eclair", 2);
            this.equipementDefensif = new EquipementDefensif("Philtre", 3, "Philtre de défence");
        }
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String setType(String type) {
        return this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public EquipementDefensif getEquipementDefensif() {
        return equipementDefensif;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }

    public EquipementOffensif getEquipementOffensif() {
        return equipementOffensif;
    }

    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }

    public int getNiveauDeVie() {
        return niveauDeVie;
    }

    public void setNiveauDeVie(int niveauDeVie) {
        this.niveauDeVie = niveauDeVie;
    }

    public int getForceDattaque() {
        return forceDattaque;
    }

    public void setForceDattaque(int forceDattaque) {
        this.forceDattaque = forceDattaque;
    }

    public String toString() {
        return ANSI_PURPLE +
                "\nPersonnage \n \n" +
                ANSI_RESET +
                "Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Niveau de vie :" + niveauDeVie + "\n" +
                "Force d'attaque: " + (forceDattaque + equipementOffensif.getNiveauAttaque()) + "\n \n" +
                ANSI_PURPLE +
                "Equipement Offensif: " +
                ANSI_RESET +
                "\n \n" + equipementOffensif + "\n \n" +
                ANSI_PURPLE +
                "Equipement Defensif: " +
                ANSI_RESET +
                " \n \n" + equipementDefensif;
    }
}
