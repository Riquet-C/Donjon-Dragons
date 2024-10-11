package personnage;

import equipements.defensif.EquipementDefensif;
import equipements.offensif.EquipementOffensif;
import equipements.potion.Potions;
import play.Menu;

import java.util.ArrayList;
import java.util.List;

abstract public class Personnage {

    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    // attributs
    private String name;
    private String type;
    private int niveauDeVie;
    private int forceDattaque;
    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;
    private final List<Potions> inventaire;

    // constructeur
    public Personnage(String name, String type) {
        this.name = name;
        this.type = type;
        this.inventaire = new ArrayList<>();
    }

    public String toString() {
        return ANSI_PURPLE + "\n=== Détails du Personnage ===\n" + ANSI_RESET + "Name: " + name + "\n" + "Type: " + type + "\n" + "Niveau de vie :" + niveauDeVie + "\n" + "Force d'attaque: " + (forceDattaque + (equipementOffensif != null ? equipementOffensif.getNiveauAttaque() : 0)) + "\n" + ANSI_PURPLE + "\n--- Équipement Offensif ---\n" + ANSI_RESET + (equipementOffensif != null ? equipementOffensif.getName() + "\n" : "Pas d'arme") + ANSI_PURPLE + "\n--- Équipement Defensif ---\n" + ANSI_RESET + (equipementDefensif != null ? equipementDefensif.getName() + "\n" : "Pas d'équipement") + ANSI_PURPLE + "============================" + ANSI_RESET;
    }

    public void addPotion(Potions potion) {
        inventaire.add(potion);
    }

    public void usePotion(Menu menu) {
        if (inventaire.isEmpty()) {
            menu.displayInventaireEmpty();
            return;
        }
        setNiveauDeVie(getNiveauDeVie() + inventaire.getFirst().getAjoutVie());
        menu.displayUsePotion(this);
        inventaire.removeFirst();
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

    protected void setEquipementDefensif(EquipementDefensif equipementDefensif) {
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
