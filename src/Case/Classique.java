package Case;

import personnage.Personnage;

public class Classique implements Case {

    private String type;

    public Classique() {
        this.type = "Classique";
    }

    @Override
    public void interact(Personnage personnage) {
        System.out.println("Je suis une case vide, repose toi" + personnage.toString() );
    }
}
