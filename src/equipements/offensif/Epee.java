package equipements.offensif;
import personnage.Personnage;
import java.util.Objects;

public class Epee extends EquipementOffensif {

    public Epee() {
        this.setType("Arme");
        this.setName("Epee");
        this.setNiveauAttaque(5);
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
