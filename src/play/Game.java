package play;

import Case.ennemis.*;
import equipements.offensif.*;
import equipements.potion.*;
import personnage.Personnage;

import java.util.*;

import Case.*;

public class Game {

    public final List<Case> plateau;
    private final Menu menu;
    private Personnage personnage1;

    public Game() {
        menu = new Menu();
        plateau = new ArrayList<>();
        addToPlateau();
    }

    public void initGame() {
        String choice = menu.displayMenuStart();
        letFirstChoice(choice);
        String choice2 = menu.displayMenuModify(personnage1);
        letModifyChoice(choice2, personnage1);
    }

    private void letFirstChoice(String choice) {
        try {
            switch (choice) {
                case "1":
                    menu.quit();
                    break;
                case "2":
                    personnage1 = menu.createPersonnage();
                    break;
                default:
                    throw new IllegalStateException("Aucun personnage n'a été créé. Veuillez créer un personnage avant de poursuivre.");
            }
        } catch (Exception IllegalStateException) {
            System.out.println(IllegalStateException.getMessage());
        }
    }

    private void letModifyChoice(String choice, Personnage personnage) {
        try {
            switch (choice) {
                case "1":
                    menu.quit();
                    break;
                case "2":
                    menu.modifyPersonnage(personnage);
                    break;
                case "3":
                    play(-1);
                default:
                    throw new IllegalStateException("Aucun personnage n'a été créé. Veuillez créer un personnage avant de poursuivre.");
            }
        } catch (Exception IllegalStateException) {
            System.out.println(IllegalStateException.getMessage());
        }
    }

//    private void letPlayChoice(String choice, Personnage personnage) {
//        try {
//            switch (choice) {
//                case "1":
//                    menu.quit();
//                    break;
//                case "2":
//                    personnage.toString();
//                    break;
//                case "3":
//                    play(positionJoueur);
//                default:
//                    throw new IllegalStateException("Aucun personnage n'a été créé. Veuillez créer un personnage avant de poursuivre.");
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

            int valueDice = dice(6);
            positionJoueur += valueDice;

            if (positionJoueur >= plateau.size() - 1) {
                menu.displayFin();
                return;
            }

            Case ceQuilYaSurLaCase = plateau.get(positionJoueur);
            menu.displayAvancement(valueDice, positionJoueur, personnage1);

            ceQuilYaSurLaCase.interact(personnage1);

            if (ceQuilYaSurLaCase instanceof Ennemis) {
                resetCase(positionJoueur);
            }

            // menu.displayMenuInGame();
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


