package equipements.potion;
import Case.*;
import personnage.Personnage;

public class Potions implements Case {
    private String type;
    private String name;
    private int ajoutVie;

    public Potions(String name, int ajoutVie){
        this.type = "Potion";
        this.name = name;
        this.ajoutVie = ajoutVie;
    }

    @Override
    public void interact(Personnage personnage) {
        System.out.println("Je suis une potion, je te rajoute " + ajoutVie + " points de vie.");
        personnage.setNiveauDeVie( personnage.getNiveauDeVie() + ajoutVie);
        System.out.println("Vos nouveaux pdv : " + personnage.getNiveauDeVie());
    }
}
