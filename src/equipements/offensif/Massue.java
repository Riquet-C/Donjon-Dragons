package equipements.offensif;
import personnage.Personnage;
import play.Menu;
import java.util.Objects;

public class Massue extends EquipementOffensif {

    public Massue() {
        this.setType("Arme");
        this.setName("Massue");
        this.setNiveauAttaque(3);
    }

    @Override
    public void interact(Personnage personnage, Menu menu) {
        menu.displayFindEquipmentOffensif(this);
        if (Objects.equals(personnage.getType(), "Guerrier")) {
            modifyEquipmentOffensif(personnage, this, menu);
        } else {
            menu.displayNotAutorizeEquipmentOffensif();
        }
    }

}