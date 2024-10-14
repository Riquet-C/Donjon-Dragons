package interactable.ennemies;

import interactable.*;
import character.Character;
import play.GameMenu;
import play.Menu;


public abstract class Ennemies implements Interactable {

    private final int attack;
    private int life;
    private String type;
    private String name;

    public Ennemies(String nom, int attack, int life) {
        this.type = "Ennemies";
        this.name = nom;
        this.attack = attack;
        this.life = life;
    }

    @Override
    public void interact(Character character, Menu menu) {
        life -= character.getAttackForce();
        if (life > 0) {
            character.setLifePoints(character.getLifePoints() - attack);
            menu.displayCurrentBattle(life);
            updateCharacterLife(character, menu);
        } else {
            GameMenu.BATTLE_VICTORY.display();
        }
    }

    private void updateCharacterLife(Character character, Menu menu) {
        if (character.getLifePoints() <= 0) {
            GameMenu.GAME_OVER.display();
            menu.quit();
        } else {
            menu.displayLifeAfterBattle(character);
        }
    }

}
