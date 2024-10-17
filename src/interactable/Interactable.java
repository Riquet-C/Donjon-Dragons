package interactable;

import character.Personnage;
import play.Menu;

/**
 * The Interactable interface defines a contract for objects that can interact with a character
 * and a menu in the game. Any class implementing this interface must provide an implementation
 * for the interact method.
 */
public interface Interactable {

    /**
     * Performs an interaction with a character using the provided menu.
     *
     * @param character the Character instance representing the player
     * @param menu the Menu instance used for user interactions
     */

    void interact(Personnage character, Menu menu);
}
