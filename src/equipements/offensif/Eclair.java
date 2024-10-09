package equipements.offensif;

import personnage.Personnage;

import java.util.Objects;

public class Eclair extends EquipementOffensif {

    public Eclair() {
        this.setType("Sort");
        this.setName("Eclair");
        this.setNiveauAttaque(2);
    }

    @Override
    public void interact(Personnage personnage) {
        if (Objects.equals(personnage.getType(), "Magicien")) {
            modifyEquipementOffensif(personnage, this);
        } else {
            System.out.println("L'arme que vous aviez trouvé n'est pas pour vous");
        }
    }

}
