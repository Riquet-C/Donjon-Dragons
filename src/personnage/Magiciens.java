package personnage;

import equipement.Philtre;
import equipement.Sort;

public class Magiciens extends Personnage {

    public Magiciens(String name) {
        super(name, "Magicien");
        this.setNiveauDeVie(6);
        this.setForceDattaque(15);
        this.setEquipementOffensif(new Sort());
        this.setEquipementDefensif(new Philtre());
    }

}
