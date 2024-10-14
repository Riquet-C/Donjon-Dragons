package character;

import equipments.defensive.Philtre;

public class Wizards extends Character {

    public Wizards(String name) {
        super(name, "Magicien");
        this.setLifePoints(6);
        this.setDefensiveEquipment(new Philtre());
        this.setAttackForce(15 + (getOffensiveEquipment() != null ?  getOffensiveEquipment().getNiveauAttaque() : 0));
    }

}
