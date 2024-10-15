package equipments.potion;

import interactable.*;
import character.Character;
import play.GameMenu;
import play.Menu;

/**
 * Classe abstraite représentant une potion dans le jeu.
 * <p>
 * Les potions peuvent être utilisées par les personnages pour restaurer des points de vie.
 * Cette classe implémente l'interface {@link Interactable}, permettant aux potions d'interagir
 * avec les personnages via un menu.
 * </p>
 */
public abstract class Potions implements Interactable {
    private final String name; // Nom de la potion
    private final int addLife;  // Points de vie ajoutés par la potion

    /**
     * Constructeur pour initialiser les attributs de la potion.
     *
     * @param name    Le nom de la potion.
     * @param addLife Le nombre de points de vie que la potion ajoute.
     */
    protected Potions(String name, int addLife) {
        this.name = name;
        this.addLife = addLife;
    }

    /**
     * Permet à un personnage d'interagir avec la potion.
     * <p>
     * Affiche un menu permettant au personnage de choisir d'utiliser la potion ou de la refuser.
     * Si le personnage choisit d'utiliser la potion, ses points de vie sont augmentés
     * par la quantité définie dans {@link #addLife}.
     * </p>
     *
     * @param character Le personnage qui interagit avec la potion.
     * @param menu     Le menu à afficher pour l'interaction.
     */
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
            default:
                break;
        }
    }

    /**
     * Obtient le nombre de points de vie ajoutés par la potion.
     *
     * @return Le nombre de points de vie que la potion ajoute.
     */
    public int getAddLife() {
        return addLife;
    }

    /**
     * Obtient le nom de la potion.
     *
     * @return Le nom de la potion.
     */
    public String getName() {
        return name;
    }
}
