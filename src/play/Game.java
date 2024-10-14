package play;

import interactable.ennemies.*;
import equipments.offensive.*;
import equipments.potion.*;
import character.Character;

import java.util.*;

import interactable.*;

public class Game {

    public final List<Interactable> board;
    private final Menu menu;
    private Character character1;
    private int playerPosition;

    public Game() {
        menu = new Menu();
        board = new ArrayList<>();
        addToPlateau();
    }

    public void initGame() {
        while (character1 == null) {
            String choice = menu.displayStart();
            letFirstChoice(choice);
        }
        String choice2 = menu.displayMenuModify();
        letModifyChoice(choice2, character1);

    }

    private void letFirstChoice(String choice) {
        switch (choice) {
            case "1":
                menu.quit();
                break;
            case "2":
                character1 = menu.createPersonnage();
        }
    }

    private void letModifyChoice(String choice, Character character) {
        switch (choice) {
            case "1":
                menu.quit();
                break;
            case "2":
                menu.modifyCharacter(character);
                String choice2 = menu.displayMenuModify();
                letModifyChoice(choice2, character1);
                break;
            case "3":
                play(-1);
        }
    }

    private void letPlayChoice(String choice, Character character, int playerPosition) {
        switch (choice) {
            case "1":
                menu.quit();
                break;
            case "2":
                System.out.println(character);
                break;
            case "3":
                play(playerPosition);
            case "4":
                character.usePotion(menu);
                String choice2 = menu.displayMenuDuringGame();
                letPlayChoice(choice2, character1, playerPosition);
        }
    }

    private void addToPlateau() {
        for (int i = 0; i < 16; i++) {
            board.add(new Classic());
        }
        for (int i = 0; i < 4; i++) {
            board.add(new Dragon());
        }
        for (int i = 0; i < 10; i++) {
            board.add(new Witch());
        }
        for (int i = 0; i < 10; i++) {
            board.add(new Goblin());
        }
        for (int i = 0; i < 5; i++) {
            board.add(new Sledgehammer());
        }
        for (int i = 0; i < 4; i++) {
            board.add(new Epee());
        }
        for (int i = 0; i < 5; i++) {
            board.add(new LightningBolt());
        }
        for (int i = 0; i < 2; i++) {
            board.add(new FireBall());

        }
        for (int i = 0; i < 6; i++) {
            board.add(new SmallPotions());
        }

        for (int i = 0; i < 2; i++) {
            board.add(new BigPotions());
        }
        Collections.shuffle(board);
    }

    public void play(int playerPosition) {

        while (playerPosition < board.size()) {

            int valueDice = dice(6);
            playerPosition += valueDice;

            if (playerPosition > board.size() - 1) {
                menu.displayEndGame();
                replayGame();
                return;
            } else if (playerPosition == board.size() - 1) {
                interactCase(valueDice, playerPosition);
                menu.displayEndGame();
            } else {
                interactCase(valueDice, playerPosition);
            }

            String choice = menu.displayMenuDuringGame();
            letPlayChoice(choice, character1, playerPosition);
        }
    }

    private int dice(int diceLenght) {
        Random dice = new Random();
        return dice.nextInt(diceLenght) + 1;
    }

    public void resetCase(int positionJoueur) {
        board.set(positionJoueur, new Classic());
    }

    public void interactCase(int valueDice, int position) {
        Interactable whatCaseItIs = board.get(position);
        menu.displayGameProgress(valueDice, position, character1);
        whatCaseItIs.interact(character1, menu);
        if (whatCaseItIs instanceof Ennemies) {
            resetCase(position);
        }
    }

    public void replayGame(){
        String choice = menu.displayMenuReplay();
        switch (choice) {
            case "1":
                menu.quit();
                break;
            case "2":
                resetPlateauAndPosition();
                play(playerPosition);
        }
    }

    public void resetPlateauAndPosition() {
        board.clear();
        addToPlateau();
        playerPosition = -1;
    }

}


