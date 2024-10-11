package equipements.offensif;

import Case.*;
import personnage.Personnage;
import play.Menu;

abstract public class EquipementOffensif implements Case {

    private String type;
    private int niveauAttaque;
    private String name;


    public String toString() {
        return "Vous avez trouvé une arme !! Voyons voir ce que c'est... Il s'agit de : " + type;
    }


    protected void modifyEquipmentOffensif(Personnage personnage, EquipementOffensif newArme, Menu menu) {
        if (personnage.getEquipementOffensif() == null || personnage.getEquipementOffensif().getNiveauAttaque() < getNiveauAttaque()) {
            personnage.setEquipementOffensif(newArme);
            personnage.setForceDattaque(getNiveauAttaque() + personnage.getForceDattaque());
            menu.displayNewEquipmentOffensif(personnage);
        } else {
            menu.displayRefuseEquipmentOffensif();
        }
    }

    // Setter & Getter
    protected void setType(String type) {
        this.type = type;
    }

    public int getNiveauAttaque() {
        return niveauAttaque;
    }

    protected void setNiveauAttaque(int niveauAttaque) {
        this.niveauAttaque = niveauAttaque;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

}
