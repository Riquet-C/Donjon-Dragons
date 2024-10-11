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
    private int positionJoueur;

    public Game() {
        menu = new Menu();
        plateau = new ArrayList<>();
        addToPlateau();
    }

    public void initGame() {
        while (personnage1 == null) {
            String choice = menu.displayMenuStart();
            letFirstChoice(choice);
        }
        String choice2 = menu.displayMenuModify();
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
                    String choice2 = menu.displayMenuModify();
                    letModifyChoice(choice2, personnage1);
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

    private void letPlayChoice(String choice, Personnage personnage, int positionJoueur) {
        try {
            switch (choice) {
                case "1":
                    menu.quit();
                    break;
                case "2":
                    System.out.println(personnage);
                    break;
                case "3":
                    play(positionJoueur);
                case "4":
                    personnage.usePotion(menu);
                    String choice2 = menu.displayMenuInGame();
                    letPlayChoice(choice2, personnage1, positionJoueur);
                default:
                    throw new IllegalStateException("Aucun personnage n'a été créé. Veuillez créer un personnage avant de poursuivre.");
            }
        } catch (Exception IllegalStateException) {
            System.out.println(IllegalStateException.getMessage());
        }
    }

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

            if (positionJoueur > plateau.size() - 1) {
                menu.displayFin();
                replayGame();
                return;
            } else if (positionJoueur == plateau.size() - 1) {
                caseInteraction(valueDice, positionJoueur);
                menu.displayFin();
            } else {
                caseInteraction(valueDice, positionJoueur);
            }

            String choice = menu.displayMenuInGame();
            letPlayChoice(choice, personnage1, positionJoueur);
        }
    }

    private int dice(int diceLenght) {
        Random dice = new Random();
        return dice.nextInt(diceLenght) + 1;
    }

    public void resetCase(int positionJoueur) {
        plateau.set(positionJoueur, new Classique());
    }

    public void caseInteraction(int valueDice, int position) {
        Case ceQuilYaSurLaCase = plateau.get(position);
        menu.displayAvancement(valueDice, position, personnage1);
        ceQuilYaSurLaCase.interact(personnage1, menu);
        if (ceQuilYaSurLaCase instanceof Ennemis) {
            resetCase(position);
        }
    }

    public void replayGame() throws PersonnageHorsPlateauException {
        String choice = menu.displayMenuReplay();
        switch (choice) {
            case "1":
                menu.quit();
                break;
            case "2":
                resetPlateauAndPosition();
                play(positionJoueur);
        }
    }

    public void resetPlateauAndPosition() {
        plateau.clear();
        addToPlateau();
        positionJoueur = -1;
    }

}


