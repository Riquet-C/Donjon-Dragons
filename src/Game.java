import Case.ennemis.Gobelin;
import equipements.offensif.Epee;
import equipements.offensif.Eclair;
import equipements.potion.Potions;
import personnage.Personnage;
import java.util.*;

import Case.*;

public class Game {

    private final List<Case> plateau;
    private final Personnage joueur;
    private int positionJoueur;
    private final Menu menu;

    public Game(Personnage personnage) {
        menu = new Menu();
        plateau = new ArrayList<>();
        addToPlateau();
        this.joueur = personnage;
    }

    private void addToPlateau() {
        plateau.add(0, new Classique());
        plateau.add(1,new Gobelin());
        plateau.add(2, new Potions("Standard", 2));
        plateau.add(3, new Epee());
        plateau.add(4, new Eclair());
    }

    public void play(int positionJoueur) {

        while (positionJoueur < plateau.size()) {

            int valueDice = this.dice(1);
            positionJoueur += valueDice;

            Case ceQuilYaSurLaCase = plateau.get(positionJoueur);
            menu.displayAvancement(valueDice, positionJoueur, joueur);

            ceQuilYaSurLaCase.interact(joueur);

            menu.playOrQuit(joueur, positionJoueur);
        }
    }

    private int dice(int diceLenght) {

        Scanner scanner = new Scanner(System.in);
        Random dice = new Random();
        return dice.nextInt(diceLenght) + 1;

    }
}


