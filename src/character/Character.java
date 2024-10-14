package character;

import equipments.defensive.DefensiveEquipment;
import equipments.offensive.OffensiveEquipment;
import equipments.potion.Potions;
import play.GameMenu;
import play.Menu;

import java.util.ArrayList;
import java.util.List;

abstract public class Character {

    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    // attributs
    private String name;
    private String type;
    private int lifePoints;
    private int attackForce;
    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;
    private final List<Potions> inventory;

    // constructeur
    public Character(String name, String type) {
        this.name = name;
        this.type = type;
        this.inventory = new ArrayList<>();
    }

    public String toString() {
        return ANSI_PURPLE + "\n=== Détails du Personnage ===\n" + ANSI_RESET + "Name: " + name + "\n" + "Type: " + type + "\n" + "Niveau de vie :" + lifePoints + "\n" + "Force d'attaque: " + (attackForce + (offensiveEquipment != null ? offensiveEquipment.getNiveauAttaque() : 0)) + "\n" + ANSI_PURPLE + "\n--- Équipement Offensif ---\n" + ANSI_RESET + (offensiveEquipment != null ? offensiveEquipment.getName() + "\n" : "Pas d'arme") + ANSI_PURPLE + "\n--- Équipement Defensif ---\n" + ANSI_RESET + (defensiveEquipment != null ? defensiveEquipment.getName() + "\n" : "Pas d'équipement") + ANSI_PURPLE + "============================" + ANSI_RESET;
    }

    public void addPotion(Potions potion) {
        inventory.add(potion);
    }

    public void usePotion(Menu menu) {
        if (inventory.isEmpty()) {
            GameMenu.EMPTY_INVENTORY.display();
            return;
        }
        setLifePoints(getLifePoints() + inventory.getFirst().getAddLife());
        menu.displayUsePotion(this);
        inventory.removeFirst();
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

    protected void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        this.defensiveEquipment = defensiveEquipment;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getAttackForce() {
        return attackForce;
    }

    public void setAttackForce(int attackForce) {
        this.attackForce = attackForce;
    }

}
