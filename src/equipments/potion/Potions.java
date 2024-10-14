package equipments.potion;

import interactable.*;
import character.Character;
import play.Game;
import play.GameMenu;
import play.Menu;

public abstract class Potions implements Interactable {
    private final String type;
    private final String name;
    private final int addLife;


    public Potions(String type, String name, int addLife) {
        this.type = type;
        this.name = name;
        this.addLife = addLife;
    }


    @Override
    public void interact(Character character, Menu menu) {
        String choice = menu.displayChoicePotion();
        switch (choice) {
            case "1":
                character.setLifePoints(character.getLifePoints() + addLife);
                GameMenu.POTION_TAKE.display(this.getName(), character.getLifePoints());
                break;
            case "2":
                GameMenu.POTION_REFUSE.display();
                character.addPotion(this);
                break;
        }

    }

    public int getAddLife() {
        return addLife;
    }

    public String getName() {
        return name;
    }
}
