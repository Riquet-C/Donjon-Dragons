package character;

import equipments.defensive.Shield;

public class Warriors extends Character {

    public Warriors(String name) {
        super(name, "Guerrier");
        this.setLifePoints(10);
        this.setDefensiveEquipment(new Shield());
        this.setAttackForce(10 + (getOffensiveEquipment() != null ?  getOffensiveEquipment().getNiveauAttaque() : 0));
    }

}
