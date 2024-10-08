package personnage;

import equipement.Arme;
import equipement.Bouclier;

public class Guerriers extends Personnage {

    public Guerriers(String name) {
        super(name, "Guerrier");
        this.setNiveauDeVie(10);
        this.setForceDattaque(10);
        this.setEquipementOffensif(new Arme("Arme", "Massue", 3));
        this.setEquipementDefensif(new Bouclier());
    }

}
