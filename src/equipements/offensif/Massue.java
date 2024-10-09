package equipements.offensif;
import personnage.Personnage;
import java.util.Objects;

public class Massue extends EquipementOffensif {

    public Massue() {
        this.setType("Arme");
        this.setName("Massue");
        this.setNiveauAttaque(3);
    }

    @Override
    public void interact(Personnage personnage) {
        System.out.println("Vous avez activée une surprise : Voyons voir de quoi il s'agit");

        if (Objects.equals(personnage.getType(), "Guerrier")) {
            modifyEquipementOffensif(personnage, this);
        } else {
            System.out.println("L'arme que vous aviez trouvé n'est pas pour vous");
        }
    }

}