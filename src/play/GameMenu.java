package play;

/**
 * Enumération représentant les différents menus et messages affichés dans le jeu.
 * <p>
 * Chaque constante de cette énumération est associée à un message spécifique qui est utilisé pour
 * l'affichage des options de menu, des informations sur les potions, l'inventaire, les équipements,
 * les batailles et les états du jeu.
 * </p>
 */
public enum GameMenu {
    // Code ANSI pour les couleurs
    ANSI_PURPLE("\u001B[35m"),
    ANSI_RESET("\u001B[0m"),
    STRING_MENU("\n=== Menu du Jeu ==="),

    // Affichage Menus
    START_MENU(ANSI_PURPLE.message + STRING_MENU.message + ANSI_RESET.message + "\n1. Quitter \n2. Creer un personnage \nChoisissez une option:"),
    MODIFY_MENU(ANSI_PURPLE.message + STRING_MENU.message + ANSI_RESET.message + "\n1. Quitter \n2. Modifier un personnage \n3. Jouer \nChoisissez une option:"),
    GAME_MENU(ANSI_PURPLE.message + STRING_MENU.message + ANSI_RESET.message + "\n1. Quitter \n2. Statistique du personnage \n3. Continuer \n4. Boire une potion \nChoisissez une option:"),
    REPLAY_MENU(ANSI_PURPLE.message + STRING_MENU.message + ANSI_RESET.message + "\n1. Quitter \n2. Rejouer \nChoisissez une option:"),

    // Affichage Case Potion
    POTION_QUESTION(ANSI_PURPLE.message + "Vous trouvez un flacon mystérieux au sol. Un liquide rougeâtre bouillonne à l'intérieur." + ANSI_RESET.message + "\nQue faites-vous ? \n1. Boire la potion \n2. Garder la potion pour plus tard"),
    POTION_REFUSE("Vous décidez de ne pas prendre la potion pour le moment, vous la gardez pour plus tard."),
    POTION_TAKE("Vous buvez une %s \nNouveau PV: %d"),

    // Inventaire
    EMPTY_INVENTORY("Votre inventaire est vide !"),

    // Equipments
    EQUIPMENTS_NOBETTER("Vous aviez trouvé une arme moins bonne que la vôtre... Vous décidez de ne pas la prendre"),
    EQUIPMENTS_NOTAUTHORIZE("L'arme que vous aviez trouvée n'est pas pour vous"),
    EQUIPMENTS_NEW("Voici votre nouvelle arme: %s \nVotre nouvelle force d'attaque est %d"),
    EQUIPMENTS_FIND("Vous avez trouvé une arme, voyons voir ce que c'est... Oh: %s"),

    // Battle
    BATTLE_VICTORY("Bravo, vous avez tué l'ennemi sans être touché"),
    BATTLE_ENNEMYLIFE("L'ennemi a encore %d points de vie"),
    BATTLE_CHARACTERLIFE("Il vous reste %d points de vie"),

    // Game Over
    GAME_OVER("Vous êtes mort.");

    private final String message;

    /**
     * Constructeur pour initialiser chaque constante de l'énumération avec son message associé.
     *
     * @param message Le message à afficher pour chaque option de menu ou état de jeu.
     */
    GameMenu(String message) {
        this.message = message;
    }

    /**
     * Affiche le message associé à l'énumération.
     *
     * @param parameters Paramètres optionnels pour formater le message.
     */
    public void display(Object... parameters) {
        System.out.printf((this.message), parameters);
    }
}
