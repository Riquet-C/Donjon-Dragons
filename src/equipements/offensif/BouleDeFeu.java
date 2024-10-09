package equipements.offensif;

import personnage.Personnage;

import java.util.Objects;

public class BouleDeFeu extends EquipementOffensif {

    public BouleDeFeu() {
        this.setType("Sort");
        this.setName("Boule De Feu");
        this.setNiveauAttaque(7);
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