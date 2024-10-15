package equipments.potion;
/**
 * Représente une grande potion dans le jeu.
 * <p>
 * Cette potion permet au personnage de restaurer une petite quantité de points de vie.
 * Elle hérite de la classe {@link Potions}.
 * </p>
 */
public class BigPotions extends Potions{
    /**
     * Constructeur de la grande potion.
     * Initialise la potion avec un nom et une quantité de vie ajoutée.
     */
    public BigPotions(){
        super("Grande Potion", 5);
    }


}
