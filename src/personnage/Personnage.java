package personnage;

import equipements.defensif.EquipementDefensif;
import equipements.offensif.EquipementOffensif;

abstract public class Personnage {

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

    // constructeur
    public Personnage(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return ANSI_PURPLE + "\npersonnage.Personnage \n \n" + ANSI_RESET +
                "Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Niveau de vie :" + niveauDeVie + "\n" +
               "Force d'attaque: " + (forceDattaque + (equipementOffensif != null ? equipementOffensif.getNiveauAttaque() : 0)) + "\n \n" +
               (equipementOffensif != null ? "\n \n" + equipementOffensif + "\n \n" : "Pas d'arme") +
                (equipementDefensif != null ? "\n \n" + equipementDefensif + "\n \n" : "Pas d'équipement");
    }


    // Setter & Getter
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

}
