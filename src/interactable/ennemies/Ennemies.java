package interactable.ennemies;

import interactable.*;
import character.Personnage;
import play.GameDisplay;
import play.GameStatus;
import play.Menu;


/**
 * The Ennemies class is an abstract representation of an enemy in the game.
 * It implements the Interactable interface, allowing enemies to interact with
 * characters during combat. This class manages the enemy's attack power, life points,
 * and interactions during battle.
 */
public abstract class Ennemies implements Interactable {

    private final int attack; // The attack power of the enemy
    private int life; // The life points of the enemy
    private String name;// The name of the enemy

    /**
     * Constructs an instance of an enemy with the specified name, attack power, and life points.
     *
     * @param nom    the name of the enemy
     * @param attack the attack power of the enemy
     * @param life   the initial life points of the enemy
     */
    public Ennemies(String nom, int attack, int life) {
        this.name = nom;
        this.attack = attack;
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Performs an interaction with the specified character and menu. This method simulates
     * a combat encounter where the enemy's life is reduced based on the character's attack
     * power. If the enemy is still alive after the attack, the character takes damage from
     * the enemy's attack. Displays the relevant battle status using the GameMenu.
     *
     * @param character the Character instance representing the player
     * @param menu      the Menu instance used for user interactions
     */
    @Override
    public void interact(Personnage character, Menu menu) {
        life -= character.getAttackForce(); // Reduce enemy life based on character's attack
        if (life > 0) {
            character.setLifePoints(character.getLifePoints() - attack); // Character takes damage
            GameDisplay.BATTLE_ENNEMYLIFE.display(life); // Display remaining enemy life
        } else {
            GameDisplay.BATTLE_VICTORY.display(); // Display victory message
        }
    }

    /**
     * Updates the character's life points and checks if the character is alive.
     * If the character's life points are zero or less, the game is over. Displays
     * the character's current life points or the game over message using the GameMenu.
     *
     * @param character the Character instance representing the player
     * @param menu      the Menu instance used for user interactions
     */
    public GameStatus attackOrQuit(Personnage character, Menu menu) {
        // Early return
        if (character.getLifePoints() <= 0) {
            GameDisplay.GAME_OVER.display(); // Display game over message
            return GameStatus.HERO_DEAD;
        }
        GameDisplay.BATTLE_CHARACTERLIFE.display(character.getLifePoints()); // Display character's life
        String choice = menu.displayMenuBattle();
        return switch (choice) {
            case "1" -> GameStatus.HERO_RETREAT;
            case "2" -> GameStatus.HERO_FIGHT;
            default -> GameStatus.GAME_INIT;
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
