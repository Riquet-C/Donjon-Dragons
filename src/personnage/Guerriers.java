package personnage;

import equipements.offensif.Epee;
import equipements.defensif.Bouclier;

public class Guerriers extends Personnage {

    public Guerriers(String name) {
        super(name, "Guerrier");
        this.setNiveauDeVie(10);
        this.setEquipementDefensif(new Bouclier());
        this.setForceDattaque(10 + (getEquipementOffensif() != null ?  getEquipementOffensif().getNiveauAttaque() : 0));
    }

}
