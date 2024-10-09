package personnage;

import equipements.defensif.Philtre;
import equipements.offensif.Eclair;

public class Magiciens extends Personnage {

    public Magiciens(String name) {
        super(name, "Magicien");
        this.setNiveauDeVie(6);
        this.setForceDattaque(15 + getEquipementOffensif().getNiveauAttaque());
        this.setEquipementOffensif(new Eclair());
        this.setEquipementDefensif(new Philtre());
    }

}
