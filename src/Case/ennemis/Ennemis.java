package Case.ennemis;

import Case.*;
import personnage.Personnage;
import play.Menu;


public abstract class Ennemis implements Case {

    private final int attaque;
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
    public void interact(Personnage personnage, Menu menu) {
        life -= personnage.getForceDattaque();
        if (life > 0) {
            personnage.setNiveauDeVie(personnage.getNiveauDeVie() - attaque);
            menu.displayCombatEnCours(life);
            majPersonnageLife(personnage, menu);

        } else {
            menu.displayCombatVictory();
        }
    }

    private void majPersonnageLife(Personnage personnage, Menu menu) {
        if (personnage.getNiveauDeVie() <= 0) {
            menu.displayGameOver();
            menu.quit();
        } else {
            menu.displayLifeAfterCombat(personnage);
        }
    }

}
