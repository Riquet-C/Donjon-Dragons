package personnage;

import equipements.defensif.Philtre;

public class Magiciens extends Personnage {

    public Magiciens(String name) {
        super(name, "Magicien");
        this.setNiveauDeVie(6);
        this.setEquipementDefensif(new Philtre());
        this.setForceDattaque(15 + (getEquipementOffensif() != null ?  getEquipementOffensif().getNiveauAttaque() : 0));
    }

}
