package interactable;

import character.Character;
import play.Menu;

/**
 * The Classic class implements the Interactable interface, providing a specific interaction
 * scenario for the game. When a character interacts with this class, they will receive a
 * narrative description of a deserted clearing.
 */
public class Classic implements Interactable {

    /**
     * Constructs a new Classic instance.
     */
    public Classic() {
    }

    /**
     * Performs an interaction with the specified character and menu, providing a narrative
     * description of a deserted clearing.
     *
     * @param character the Character instance representing the player
     * @param menu the Menu instance used for user interactions
     */
    @Override
    public void interact(Character character, Menu menu) {
        System.out.println("Vous arrivez sur une clairière déserte, balayée par le vent. Rien ne semble s'y passer...");
        System.out.println("Le silence est inquiétant. Vous reprenez votre souffle avant de continuer.");
    }
}
