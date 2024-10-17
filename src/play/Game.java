package play;


import interactable.ennemies.*;
import equipments.offensive.*;
import equipments.potion.*;
import character.Character;

import java.util.*;

import interactable.*;

/**
 * This class represents the main game. It handles initialization, the management of
 * interactions with the board, and game flow.
 */
public class Game {

    /**
     * List of Interactable object on the board during the game
     */
    public final List<Interactable> board;
    /**
     * Menu for displaying options and retrieving player choices.
     */
    private final Menu menu;
    /**
     * player-created character.
     */
    private Character character1;

    private GameStatus status;

    /**
     * Actual player position
     */
    private int playerPosition;

    /**
     * Build the game, instantiate the menu, the board and the objects on the board
     */
    public Game() {
        menu = new Menu();
        board = new ArrayList<>();
        addToPlateau();
        status = GameStatus.GAME;
    }


    /**
     * Initialize the game with the player's first choices: create a character or quit
     */
    public void initGame() {
        while (character1 == null) {
            String choice = menu.displayStart();
            letFirstChoice(choice);
        }
        String choice2 = menu.displayMenuModify();
        letModifyChoice(choice2, character1);

    }

    /**
     * method that handles the player's choice in the first game menu (quit or create a character)
     *
     * @param choice Player choice as String
     */
    private void letFirstChoice(String choice) {
        switch (choice) {
            case "1":
                menu.quit();
                break;
            case "2":
                character1 = menu.createPersonnage();
                break;
            default:
                break;
        }
    }

    /**
     * method that handles the player's choice in the second game menu (quit, modify character or play)
     *
     * @param choice    Player choice as String
     * @param character player-created character.
     */
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
                break;
            default:
                break;
        }
    }

    /**
     * method that handles the player's choice in the game menu (quit, show character, play or use potion)
     *
     * @param choice         Player choice as String
     * @param character      player-created character.
     * @param playerPosition Actual player position
     */
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
                break;
            case "4":
                character.usePotion();
                String choice2 = menu.displayMenuDuringGame();
                letPlayChoice(choice2, character1, playerPosition);
                break;
            default:
                break;
        }
    }



    /**
     * Add object on the Board (Ennemies, Surprise or Classique)
     */
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

    /**
     * Unwinds the game by advancing the player on the board according to the result
     * of the dice roll. Interactions with squares and the menu are handled in this method.
     *
     * @param playerPosition The player's initial position on the board.
     */
    public void play(int playerPosition) {

        while (playerPosition < board.size()) {

            int valueDice = dice();
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

    /**
     * roll the dice with random
     *
     * @return the result of random between 1 and 6
     */
    private int dice() {
        Random dice = new Random();
        return dice.nextInt(6) + 1;
    }

    /**
     * Removes the enemy killed by the player from the square
     *
     * @param playerPosition Actual player position
     */
    public void resetCase(int playerPosition) {
        board.set(playerPosition, new Classic());
    }

    /**
     * Interaction with the board square
     *
     * @param valueDice Value of dice return by method dice
     * @param position  Actual player position
     */
    public void interactCase(int valueDice, int position) {
        Interactable whatCaseItIs = board.get(position);
        menu.displayGameProgress(valueDice, position, character1);
        whatCaseItIs.interact(character1, menu);
        if (whatCaseItIs instanceof Ennemies enemy) {
            status = enemy.attackOrQuit(character1, menu);
            if (enemy.getLife() <= 0){
                resetCase(position);
            } else if (status == GameStatus.HERO_FIGHT) {
                whatCaseItIs.interact(character1, menu);
            } else if (status == GameStatus.HERO_RETREAT) {
                int valueDiceRetreat = dice();
                playerPosition -= valueDiceRetreat;
            } else if (status == GameStatus.HERO_DEAD){
                menu.quit();
            } else if (status == GameStatus.GAME) {
                System.out.println("default");
            }

        }
    }

    /**
     * When player end and win the game, he can replay or quit
     */
    public void replayGame() {
        String choice = menu.displayMenuReplay();
        switch (choice) {
            case "1":
                menu.quit();
                break;
            case "2":
                resetPlateauAndPosition();
                play(playerPosition);
                break;
            default:
                break;
        }
    }

    /**
     * reset board and player position for replay
     */
    public void resetPlateauAndPosition() {
        board.clear();
        addToPlateau();
        playerPosition = -1;
    }
}


