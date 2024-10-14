package play;

import equipments.offensive.OffensiveEquipment;
import equipments.potion.Potions;
import character.*;
import character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Menu {
    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    // Menu affichage
    private String ask(String question, List<String> availableAnswers) throws Exception {
        if (availableAnswers == null || availableAnswers.isEmpty()) {
            throw new Exception("No possible answers available");
        }
        System.out.println(question);
        String answer = scanner.nextLine();
        if (!availableAnswers.contains(answer)) {
            throw new Exception("Not acceptable answer");
        }
        return answer;
    }

    public String displayStart() {
        String question = String.valueOf(GameMenu.START_MENU);
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2"));
        try {
            return ask(question, availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayStart();
        }
    }

    public String displayMenuModify() {
        String question = String.valueOf(GameMenu.MODIFY_MENU);
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2", "3"));
        try {
            return ask(question, availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayMenuModify();
        }
    }

    public String displayMenuDuringGame() {
        String question = String.valueOf(GameMenu.GAME_MENU);
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2", "3", "4"));
        try {
            return ask(question, availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayMenuDuringGame();
        }
    }

    public String displayMenuReplay() {
        String question = String.valueOf(GameMenu.REPLAY_MENU);
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2"));
        try {
            return ask(question, availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayMenuReplay();
        }
    }

    // creer personnage (appeler par Start)
    public Character createPersonnage() {

        // Choix du Nom
        System.out.println("Ecrire votre nom:");
        String name = scanner.nextLine();

        switch (name) {
            case "quit":
                quit();
                break;
            case "":
                name = "Toto";
                break;
        }

        // Choix du type de perso
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

    // modifier personnage
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
                }

                break;

            } else {
                System.out.println("Votre choix n'est pas valide. Veuillez choisir 1 ou 2");
            }
        }
        System.out.println(character);
    }

    // Affichage durant le jeu
    public void displayGameProgress(int valueDice, int positionJoueur, Character character) {
        System.out.println("+-----+\n" + "|  " + valueDice + "  |\n" + "+-----+");
        try {
            sleep(400);  // Ajout du sleep avec une gestion d'exception
        } catch (InterruptedException e) {
            System.out.println("Le processus a été interrompu : " + e.getMessage());
        }
        System.out.println(character.getName() + " avance à la case: " + (positionJoueur + 1));
    }

    public void displayEndGame() {
        try {
            sleep(400);  // Ajout du sleep avec une gestion d'exception
        } catch (InterruptedException e) {
            System.out.println("Le processus a été interrompu : " + e.getMessage());
        }
        System.out.println("Vous avez gagné !" + "\n" + "                                                     //\n" + "                           _                        //\n" + "                        ,-'_`----,_                //\n" + "                       (  _~d~~_/ '~-----,        //\n" + "                       (_<_~~~~_,----==='        //\n" + "                  __    /  ~~~~=--~~~~          //\n" + "                 /  \\   |   /~~                //\n" + "                 \\_ |   \\   \\                 //\n" + "                 (_ |    \\   \\_              //\n" + "                   L|     \\_   \\_           //\n" + "                   ||       \\_   \\_        //\n" + "               _____U         \\_   \\_     //\n" + "              |  __ \\           \\_   \\_  //\n" + "              |  \\_\\_|            \\_   \\//\n" + "              |______|              \\_ //_\n" + "              |_______\\               //  \\\n" + "               |  |    \\             //\\   \\\n" + "               |  |     \\-_         //  |   \\\n" + "               |  '-,_ / / ,-______//   |__  \\\n" + "               \\----  '-/_/ /||||_  ~),-   ~--\\\n" + "                ~\\_      /-/_'~~~/\\_)/_/       ~\\\n" + "           _       \\_   /  / /~~/ /-__ `-/_  ,   |\n" + "         _/ ),--,    \\_/  /  | / //   -,__ `/_ | |\n" + "        /   ',-, |,_   \\_/  / / //    /   \\  \\// |\n" + "       /      _)    )-~~(   |/ /_Z--_/_   /    `/\n" + "      |  /    _~) /~    -`--/ /~ \\   \\ ~-/      |\n" + "      | /    ' ~,,--,  (   / /`\\__\\_--~~~      |\n" + "      \\|        /      )  / /~~              _/\n" + "        \\_            / _/ /          \\    _/\n" + "          \\          | // /            | _/\n" + "           `-__/     |// /            /_-\n" + "              `--,__/ / /          __--\n" + "                 _-' / /       __--\n" + "              _-'   / /    __--\n" + "           _-'     / / __-- --___\n" + "        _-'   ___-/ /--  ~~~---__`--,___\n" + "      _/   __/,--/ /,--,--_____ _~`-----'-----,\n" + "   ,-~ __,- _//_/ //__/__/_/_/_//~~~~--r-,.\\  )\n" + "  |   /  _/~,/ / /             ~~~~~~~~`-`) | (\n" + "  \\_,| ./ ,'  / /                       (~  o  )\n" + "  |_,|~|_/   / /                         ) _  /\n" + "  (_,|~||   / /                          |/ )/\n" + "  (_// /|  / /                           / /\n" + "  | | ||  / /                            |/\n" + "  / | || / /\n" + " /  | ||/ /      \n" + "(_ | ,'/ /  \n" + "( `/ ||\\/             \n" + " \\/ | \\_\n" + " |  \\_  `_\n" + "  \\ ,-,\\,-,`,\n" + "   \\_\\_\\\\\\ \\ \\\n" + "    ~~~~~~~~~~~");
    }

    // Affichage sur Case Potion
    public String displayChoicePotion() {
        String question = String.valueOf(GameMenu.POTION_QUESTION);
        List<String> availableAnswers = new ArrayList<>(List.of("1", "2"));
        try {
            return ask(question, availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return displayChoicePotion();
        }
    }

    public void displayUsePotion(Character character) {
        System.out.println("Vous avez bu une potion, vos nouveaux pv sont: " + character.getLifePoints());

    }

    // Affichage sur Case Equipment Offensif
    public void displayFindEquipmentOffensif(OffensiveEquipment newArme) {
        System.out.println(newArme);
    }

    public void displayNewEquipmentOffensif(Character character) {
        System.out.println("Voici votre nouvel arme: " + character.getOffensiveEquipment().getName() + "\nVotre nouvelle force d'attaque est: " + character.getAttackForce());
    }


    // Affichage sur Case Ennemi
    public void displayCurrentBattle(int ennemiLife) {
        System.out.println("L'ennemis à encore " + ennemiLife + " points de vies");
    }

    public void displayLifeAfterBattle(Character character) {
        System.out.println("Il vous reste " + character.getLifePoints() + " points de vies");
    }


    // de quoi eviter la redondance dans le menu lui même
    public boolean isValideType(String type) {
        return type.equalsIgnoreCase("1") || type.equalsIgnoreCase("2");
    }

    public void quit() {
        System.out.println("Fin de la partie");
        System.exit(0);
    }

}
