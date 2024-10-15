package equipments.potion;

/**
 * Représente une petite potion dans le jeu.
 * <p>
 * Cette potion permet au personnage de restaurer une petite quantité de points de vie.
 * Elle hérite de la classe {@link Potions}.
 * </p>
 */
public class SmallPotions extends Potions {

    /**
     * Constructeur de la petite potion.
     * Initialise la potion avec un nom et une quantité de vie ajoutée.
     */
    public SmallPotions() {
        super("Petite Potion", 2);
    }
}
