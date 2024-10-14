package play;

import java.util.Objects;

public enum GameMenu {
    // Code ANSI pour les couleurs
    ANSI_PURPLE("\u001B[35m"),
    ANSI_RESET("\u001B[0m"),

    // Affichage Menus
    START_MENU(ANSI_PURPLE + "=== Menu du Jeu ===" + ANSI_RESET + "\n1. Quitter \n2. Creer un personnage \nChoisissez une option:"),
    MODIFY_MENU(ANSI_PURPLE + "=== Menu du Jeu ===" + ANSI_RESET + "\n1. Quitter \n2. Modifier un personnage \n3. Jouer \nChoisissez une option:"),
    GAME_MENU(ANSI_PURPLE + "=== Menu du Jeu ===" + ANSI_RESET + "\n1. Quitter \n2. Statistique du personnage \n3. Continuer \n4. Boire une potion \nChoisissez une option:"),
    REPLAY_MENU(ANSI_PURPLE + "=== Menu du Jeu ===" + ANSI_RESET + "\n1. Quitter \n2. Rejouer \nChoisissez une option:"),

    // Affichage Case Potion
    POTION_QUESTION(ANSI_PURPLE + "Vous trouvez un flacon mystérieux au sol. Un liquide rougeâtre bouillonne à l'intérieur." + ANSI_RESET + "\nQue faites-vous ? \n1. Boire la potion \n2. Garder la potion pour plus tard"),
    POTION_REFUSE("Vous décidez de ne pas prendre la potion pour le moment, vous la gardez pour plus tard."),
    POTION_TAKE("Vous buvez une %s \nNouveau PV: %s"),

    // Inventaire
    EMPTY_INVENTORY("Votre inventaire est vide !"),

    // Equipments
    EQUIPMENTS_NOBETTER("Vous aviez trouver une arme moins bonne que la votre... Vous décidez de ne pas la prendre"),
    EQUIPMENTS_NOTAUTHORIZE("L'arme que vous aviez trouvé n'est pas pour vous"),

    // Battle
    BATTLE_VICTORY("Bravo, vous avez tuer l'ennemis sans être touché"),

    // Game Over
    GAME_OVER("Vous êtes mort. Fin de la partie !");

    private final String message;

    GameMenu(String message) {
        this.message = message;
    }

    public void display(Object... parameters) {
        System.out.println(this.message);
    }
}

