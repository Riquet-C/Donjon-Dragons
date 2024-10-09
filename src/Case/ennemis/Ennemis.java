package Case.ennemis;

import Case.Case;
import personnage.Personnage;

public abstract class Ennemis implements Case {

    private int attaque;
    private int life;
    private String type;
    private String name;

    public Ennemis(String nom, int attaque, int life) {
        this.type = "Ennemis";
        this.name = nom;
        this.attaque = attaque;
        this.life = life;
    }

    @Override
    public void interact(Personnage personnage) {
        life -= personnage.getForceDattaque();
        if (life > 0) {
            personnage.setNiveauDeVie(personnage.getNiveauDeVie() - attaque);
            System.out.println("L'ennemis à encore " + life + " points de vies");
            System.out.println("Il vous reste " + personnage.getNiveauDeVie() + " points de vies");
        } else {
//            plateau.set(positionJoueur, new Classique());
            System.out.println("Bravo, vous avez tuer l'ennemis");
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public String getType() {
        return type;
    }

}
