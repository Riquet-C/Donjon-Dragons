import java.util.Random;


public class Game {

    private final String joueurName;
    private final Personnage joueur;
    private int positionJoueur;
    private Menu menu;

    public Game(Personnage personnage) {
        menu = new Menu();
        this.joueur = personnage;
        this.joueurName = personnage.getName();
        this.positionJoueur = 1;
    }

    public void play() {
        while (positionJoueur <= 64) {
            if (positionJoueur < 58) {
                int lanceDice = this.dice(6);
                positionJoueur += lanceDice;
                System.out.println(lanceDice);
                System.out.println(joueurName + ": " + positionJoueur);
            } else if (positionJoueur < 64) {
                int lanceDice = this.dice(64 - positionJoueur);
                positionJoueur += lanceDice;
                System.out.println(lanceDice);
                System.out.println(joueurName + ": " + positionJoueur);
            } else {
                menu.quitPlayModify(joueur);
            }
        }
    }

    public int dice(int diceLenght) {
        Random dice = new Random();
        return dice.nextInt(diceLenght) + 1;
    }

}
