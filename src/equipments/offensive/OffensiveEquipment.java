package equipments.offensive;

import interactable.*;
import character.Character;
import play.GameMenu;
import play.Menu;

abstract public class OffensiveEquipment implements Interactable {

    private String type;
    private int niveauAttaque;
    private String name;


    public String toString() {
        return "Vous avez trouvé une arme !! Voyons voir ce que c'est... Il s'agit de : " + type;
    }


    protected void modifyEquipmentOffensif(Character character, OffensiveEquipment newArme, Menu menu) {
        if (character.getOffensiveEquipment() == null || character.getOffensiveEquipment().getNiveauAttaque() < getNiveauAttaque()) {
            character.setOffensiveEquipment(newArme);
            character.setAttackForce(getNiveauAttaque() + character.getAttackForce());
            menu.displayNewEquipmentOffensif(character);
        } else {
            GameMenu.EQUIPMENTS_NOBETTER.display();
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

    public abstract void interact(Character character, Menu menu);
}
