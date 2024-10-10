package equipements.potion;
import Case.*;
import personnage.Personnage;

public abstract class Potions implements Case {
    private final String type;
    private final String name;
    private final int ajoutVie;

    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Potions(String type, String name, int ajoutVie){
        this.type = type;
        this.name = name;
        this.ajoutVie = ajoutVie;
    }

    public String toString() {
        return ANSI_PURPLE + "Potions: " + ANSI_RESET +
                "\nname: " + name + "\n" +
                "type: " + type + "\n" +
                "Nombre de point de vie ajouté: +" + ajoutVie;
    }

    @Override
    public void interact(Personnage personnage) {
        System.out.println("Je suis une potion, je te rajoute " + ajoutVie + " points de vie.");
        personnage.setNiveauDeVie( personnage.getNiveauDeVie() + ajoutVie);
        System.out.println("Vos nouveaux pdv : " + personnage.getNiveauDeVie());
    }

}
