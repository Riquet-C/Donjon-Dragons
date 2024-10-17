package play;

import character.*;
import character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
 * The Menu class handles the display and management of various game menus.
 * It allows for user interaction through the console, facilitating character creation, modification,
 * and displaying game progress and results.
 */
public class Menu {
    private final Scanner scanner;

    /**
     * Constructs a new Menu instance and initializes the scanner for user input.
     */
    public Menu() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user for input based on the available answers.
     *
     * @param availableAnswers a list of valid answers
     * @return the user's answer
     * @throws Exception if no valid answers are available or if the input is not acceptable
     */
    private String ask(List<String> availableAnswers) throws Exception {
        if (availableAnswers == null || availableAnswers.isEmpty()) {
            throw new Exception("No possible answers available");
        }
        String answer = scanner.nextLine();
        if (!availableAnswers.contains(answer)) {
            throw new Exception("Not acceptable answer");
        }
        return answer;
    }

    /**
     * Displays the start menu and prompts the user for a selection.
     *
     * @return the user's choice from the start menu
     */
    public String displayStart() {
        GameDisplay.START_MENU.display();
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2"));
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayStart();
        }
    }

    /**
     * Displays the modification menu and prompts the user for a selection.
     *
     * @return the user's choice from the modification menu
     */
    public String displayMenuModify() {
        GameDisplay.MODIFY_MENU.display();
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2", "3"));
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayMenuModify();
        }
    }

    /**
     * Displays the game menu during gameplay and prompts the user for a selection.
     *
     * @return the user's choice from the game menu
     */
    public String displayMenuDuringGame() {
        GameDisplay.GAME_MENU.display();
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2", "3", "4"));
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayMenuDuringGame();
        }
    }

    /**
     * Displays the replay menu and prompts the user for a selection.
     *
     * @return the user's choice from the replay menu
     */
    public String displayMenuReplay() {
        GameDisplay.REPLAY_MENU.display();
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2"));
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayMenuReplay();
        }
    }


    public String displayMenuBattle(){
        GameDisplay.REPLAY_BATTLE.display();
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2"));
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayMenuReplay();
        }
    }

    /**
     * Creates a new character based on user input for name and type.
     *
     * @return the newly created Character instance
     */
    public Character createPersonnage() {
        // Choose a name
        System.out.println("Ecrire votre nom:");
        String name = scanner.nextLine();

        switch (name) {
            case "quit":
                quit();
                break;
            case "":
                name = "Toto";
                break;
            default:
                break;
        }

        // Choose character type
        System.out.println("Choisissez votre type: 1 = Guerrier ou 2 = Magicien");
        String type = scanner.nextLine();

        Character character1 = null;

        if (type.equalsIgnoreCase("quit")) {
            quit();
        } else if (isValideType(type)) {
            character1 = switch (type) {
                case "1" -> new Warriors(name);
                case "2" -> new Wizards(name);
                default -> throw new IllegalStateException("Unexpected value: " + type);
            };
        } else {
            System.out.println("Votre choix ne correspond pas à Magicien ou Guerrier, un personnage va être généré automatiquement");
            character1 = new Warriors(name);
        }
        System.out.println(character1);
        return character1;
    }

    /**
     * Modifies an existing character based on user input.
     *
     * @param character the Character instance to be modified
     */
    public void modifyCharacter(Character character) {
        System.out.println("Ecrire votre nom:");
        String name = scanner.nextLine();

        if (name != null && !name.isEmpty()) {
            character.setName(name);
        }

        while (true) {
            System.out.println("Choisissez votre type: 1 = Guerrier ou 2 = Magicien");
            String type = scanner.nextLine();

            if (isValideType(type) && !type.equalsIgnoreCase(character.getType())) {
                character.setType(type);

                switch (type.toLowerCase()) {
                    case "1":
                        character = new Warriors(character.getName());
                        break;
                    case "2":
                        character = new Wizards(character.getName());
                        break;
                    default:
                        break;
                }

                break;

            } else {
                System.out.println("Votre choix n'est pas valide. Veuillez choisir 1 ou 2");
            }
        }
        System.out.println(character);
    }

    /**
     * Displays the progress of the game, including the value of the dice roll and the character's position.
     *
     * @param valueDice      the value rolled on the dice
     * @param positionJoueur the current position of the player
     * @param character      the Character instance representing the player
     */
    public void displayGameProgress(int valueDice, int positionJoueur, Character character) {
        System.out.println("+-----+\n" + "|  " + valueDice + "  |\n" + "+-----+");
        try {
            sleep(400);  // Add sleep with exception handling
        } catch (InterruptedException e) {
            System.out.println("Le processus a été interrompu : " + e.getMessage());
        }
        System.out.println(character.getName() + " avance à la case: " + (positionJoueur + 1));
    }

    /**
     * Displays the end game message indicating victory.
     */
    public void displayEndGame() {
        try {
            sleep(400);  // Add sleep with exception handling
        } catch (InterruptedException e) {
            System.out.println("Le processus a été interrompu : " + e.getMessage());
        }
        System.out.println("Vous avez gagné !");
    }

    /**
     * Displays the potion choice question and prompts the user for a selection.
     *
     * @return the user's choice regarding the potion
     */
    public String displayChoicePotion() {
        GameDisplay.POTION_QUESTION.display();
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2"));
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayChoicePotion();
        }
    }

    /**
     * Validates the character type input.
     *
     * @param type the type of character as a string
     * @return true if the type is valid; otherwise, false
     */
    public boolean isValideType(String type) {
        return type.equalsIgnoreCase("1") || type.equalsIgnoreCase("2");
    }

    /**
     * Exits the game and displays a farewell message.
     */
    public void quit() {
        System.out.println("Fin de la partie !");
        System.exit(0);
    }
}
