import personnage.Personnage;

import java.util.Random;


public class Game {

    private final Personnage joueur;
    private int positionJoueur;
    private final Menu menu;

    public Game(Personnage personnage) {
        menu = new Menu();
        this.joueur = personnage;
        this.positionJoueur = 1;
    }

    public void play() {
        while (positionJoueur <= 64) {
            if (positionJoueur < 58) {
                int valueDice = this.dice(6);
                positionJoueur += valueDice;
                menu.displayAvancement(valueDice, positionJoueur, joueur);
            } else if (positionJoueur < 64) {
                int valueDice = this.dice(64 - positionJoueur);
                positionJoueur += valueDice;
                menu.displayAvancement(valueDice, positionJoueur, joueur);
            } else {
                menu.displayFin();
                menu.quitPlayModify(joueur);
            }
        }
    }

    public int dice(int diceLenght) {
        Random dice = new Random();
        return dice.nextInt(diceLenght) + 1;
    }

}
