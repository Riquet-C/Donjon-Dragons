package play;

import Case.ennemis.*;
import equipements.offensif.*;
import equipements.potion.*;
import personnage.Personnage;

import java.util.*;

import Case.*;

public class Game {

    public final List<Case> plateau;
    private final Personnage joueur;
    private int positionJoueur;
    private final Menu menu;

    public Game(Personnage personnage) {
        menu = new Menu();
        plateau = new ArrayList<>();
        addToPlateau();
        this.joueur = personnage;
    }

//    private void initGame() {
//        String choice = menu.start();
//        getChoice(choice);
//    }
//
//    private void getChoice(String choice) {
//        try {
//            Personnage personnage1 = null;
//            switch (choice) {
//                case "1":
//                    menu.quit();
//                    break;
//                case "2":
//                    personnage1 = menu.createPersonnage();
//                    menu.quitPlayModify(personnage1);
//                    break;
//                default:
//                    throw new IllegalStateException("Aucun personnage n'a été créé. Veuillez créer un personnage avant de jouer.");
//            }
//        } catch (Exception IllegalStateException) {
//            System.out.println(IllegalStateException.getMessage());
//        }
//    }

    private void addToPlateau() {
        for (int i = 0; i < 16; i++) {
            plateau.add(new Classique());
        }
        for (int i = 0; i < 4; i++) {
            plateau.add(new Dragon());
        }
        for (int i = 0; i < 10; i++) {
            plateau.add(new Sorcier());
        }
        for (int i = 0; i < 10; i++) {
            plateau.add(new Gobelin());
        }
        for (int i = 0; i < 5; i++) {
            plateau.add(new Massue());
        }
        for (int i = 0; i < 4; i++) {
            plateau.add(new Epee());
        }
        for (int i = 0; i < 5; i++) {
            plateau.add(new Eclair());
        }
        for (int i = 0; i < 2; i++) {
            plateau.add(new BouleDeFeu());

        }
        for (int i = 0; i < 6; i++) {
            plateau.add(new PetitesPotions());
        }

        for (int i = 0; i < 2; i++) {
            plateau.add(new GrandePotions());
        }
        Collections.shuffle(plateau);
    }

    public void play(int positionJoueur) throws PersonnageHorsPlateauException {

        while (positionJoueur < plateau.size()) {

            int valueDice = this.dice(6);
            positionJoueur += valueDice;

            if (positionJoueur > plateau.size()) {
                throw new PersonnageHorsPlateauException();
            } else {
                Case ceQuilYaSurLaCase = plateau.get(positionJoueur);
                menu.displayAvancement(valueDice, positionJoueur, joueur);

                ceQuilYaSurLaCase.interact(joueur);

                if (ceQuilYaSurLaCase instanceof Ennemis) {
                    resetCase(positionJoueur);
                }

                if (positionJoueur == plateau.size() - 1) {
                    menu.displayFin();
                }

                menu.playOrQuit(joueur, positionJoueur);
            }
        }
    }

    private int dice(int diceLenght) {
        Scanner scanner = new Scanner(System.in);
        Random dice = new Random();
        return dice.nextInt(diceLenght) + 1;
    }

    public void resetCase(int positionJoueur) {
        plateau.set(positionJoueur, new Classique());
    }

}


