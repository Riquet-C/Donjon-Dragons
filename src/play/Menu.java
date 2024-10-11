package play;

import equipements.offensif.EquipementOffensif;
import equipements.potion.Potions;
import personnage.*;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Menu {
    private final Scanner scanner;
    // attributs couleurs
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Menu() {
        scanner = new Scanner(System.in);
    }

    // Menu affichage
    public String displayMenuStart() {
        System.out.println(ANSI_PURPLE + "=== Menu du Jeu ===" + ANSI_RESET);
        System.out.println("1. Quitter");
        System.out.println("2. Creer un personnage");
        System.out.print("Choisissez une option : ");
        return scanner.nextLine();
    }

    public String displayMenuModify() {
        System.out.println(ANSI_PURPLE + "=== Menu du Jeu ===" + ANSI_RESET);
        System.out.println("1. Quitter");
        System.out.println("2. Modifier un personnage");
        System.out.println("3. Jouer");
        System.out.print("Choisissez une option : ");
        return scanner.nextLine();
    }

    public String displayMenuInGame() {
        System.out.println(ANSI_PURPLE + "=== Menu du Jeu ===" + ANSI_RESET);
        System.out.println("1. Quitter");
        System.out.println("2. Statistique du personnage");
        System.out.println("3. Continuer");
        System.out.println("4. Boire une potion");
        System.out.print("Choisissez une option : ");
        return scanner.nextLine();
    }

    public String displayMenuReplay() {
        System.out.println(ANSI_PURPLE + "=== Menu du Jeu ===" + ANSI_RESET);
        System.out.println("1. Quitter");
        System.out.println("2. Rejouer");
        System.out.print("Choisissez une option : ");
        return scanner.nextLine();
    }

    // creer personnage (appeler par Start)
    public Personnage createPersonnage() {

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

        Personnage personnage1 = null;

        if (type.equalsIgnoreCase("quit")) {
            quit();
        } else if (isValideType(type)) {
            personnage1 = switch (type) {
                case "1" -> new Guerriers(name);
                case "2" -> new Magiciens(name);
                default -> throw new IllegalStateException("Unexpected value: " + type);
            };
        } else {
            System.out.println("Votre choix ne correspond pas à Magicien ou Guerrier, un personnage va être généré automatiquement");
            personnage1 = new Guerriers(name);
        }
        System.out.println(personnage1);
        return personnage1;
    }

    // modifier personnage
    public void modifyPersonnage(Personnage personnage) {

        System.out.println("Ecrire votre nom:");
        String name = scanner.nextLine();

        if (name != null && !name.isEmpty()) {
            personnage.setName(name);
        }

        while (true) {
            System.out.println("Choisissez votre type: 1 = Guerrier ou 2 = Magicien");
            String type = scanner.nextLine();

            if (isValideType(type) && !type.equalsIgnoreCase(personnage.getType())) {
                personnage.setType(type);

                switch (type.toLowerCase()) {
                    case "1":
                        personnage = new Guerriers(personnage.getName());
                        break;
                    case "2":
                        personnage = new Magiciens(personnage.getName());
                        break;
                }

                break;

            } else {
                System.out.println("Votre choix n'est pas valide. Veuillez choisir 1 ou 2");
            }
        }
        System.out.println(personnage);
    }

    // Affichage durant le jeu
    public void displayAvancement(int valueDice, int positionJoueur, Personnage personnage) {
        System.out.println(
                "+-----+\n" +
                        "|  " + valueDice + "  |\n" +
                        "+-----+");
        try {
            sleep(400);  // Ajout du sleep avec une gestion d'exception
        } catch (InterruptedException e) {
            System.out.println("Le processus a été interrompu : " + e.getMessage());
        }
        System.out.println(personnage.getName() + " avance à la case: " + (positionJoueur + 1));
    }

    public void displayFin() {
        try {
            sleep(400);  // Ajout du sleep avec une gestion d'exception
        } catch (InterruptedException e) {
            System.out.println("Le processus a été interrompu : " + e.getMessage());
        }
        System.out.println("Vous avez gagné !" +
                "\n" +
                "                                                     //\n" +
                "                           _                        //\n" +
                "                        ,-'_`----,_                //\n" +
                "                       (  _~d~~_/ '~-----,        //\n" +
                "                       (_<_~~~~_,----==='        //\n" +
                "                  __    /  ~~~~=--~~~~          //\n" +
                "                 /  \\   |   /~~                //\n" +
                "                 \\_ |   \\   \\                 //\n" +
                "                 (_ |    \\   \\_              //\n" +
                "                   L|     \\_   \\_           //\n" +
                "                   ||       \\_   \\_        //\n" +
                "               _____U         \\_   \\_     //\n" +
                "              |  __ \\           \\_   \\_  //\n" +
                "              |  \\_\\_|            \\_   \\//\n" +
                "              |______|              \\_ //_\n" +
                "              |_______\\               //  \\\n" +
                "               |  |    \\             //\\   \\\n" +
                "               |  |     \\-_         //  |   \\\n" +
                "               |  '-,_ / / ,-______//   |__  \\\n" +
                "               \\----  '-/_/ /||||_  ~),-   ~--\\\n" +
                "                ~\\_      /-/_'~~~/\\_)/_/       ~\\\n" +
                "           _       \\_   /  / /~~/ /-__ `-/_  ,   |\n" +
                "         _/ ),--,    \\_/  /  | / //   -,__ `/_ | |\n" +
                "        /   ',-, |,_   \\_/  / / //    /   \\  \\// |\n" +
                "       /      _)    )-~~(   |/ /_Z--_/_   /    `/\n" +
                "      |  /    _~) /~    -`--/ /~ \\   \\ ~-/      |\n" +
                "      | /    ' ~,,--,  (   / /`\\__\\_--~~~      |\n" +
                "      \\|        /      )  / /~~              _/\n" +
                "        \\_            / _/ /          \\    _/\n" +
                "          \\          | // /            | _/\n" +
                "           `-__/     |// /            /_-\n" +
                "              `--,__/ / /          __--\n" +
                "                 _-' / /       __--\n" +
                "              _-'   / /    __--\n" +
                "           _-'     / / __-- --___\n" +
                "        _-'   ___-/ /--  ~~~---__`--,___\n" +
                "      _/   __/,--/ /,--,--_____ _~`-----'-----,\n" +
                "   ,-~ __,- _//_/ //__/__/_/_/_//~~~~--r-,.\\  )\n" +
                "  |   /  _/~,/ / /             ~~~~~~~~`-`) | (\n" +
                "  \\_,| ./ ,'  / /                       (~  o  )\n" +
                "  |_,|~|_/   / /                         ) _  /\n" +
                "  (_,|~||   / /                          |/ )/\n" +
                "  (_// /|  / /                           / /\n" +
                "  | | ||  / /                            |/\n" +
                "  / | || / /\n" +
                " /  | ||/ /      \n" +
                "(_ | ,'/ /  \n" +
                "( `/ ||\\/             \n" +
                " \\/ | \\_\n" +
                " |  \\_  `_\n" +
                "  \\ ,-,\\,-,`,\n" +
                "   \\_\\_\\\\\\ \\ \\\n" +
                "    ~~~~~~~~~~~");
    }

    // Affichage sur Case Potion
    public String displayChoicePotion() {
        System.out.println("Vous trouvez un flacon mystérieux au sol. Un liquide rougeâtre bouillonne à l'intérieur.");
        System.out.println("Que faites-vous ?");
        System.out.println("1. Boire la potion");
        System.out.println("2. Garder la potion pour plus tard");
        return scanner.nextLine();
    }

    public void displayTakePotion(Potions potion, Personnage personnage) {
        System.out.println(potion);
        System.out.println("Nouveau PV: " + personnage.getNiveauDeVie());
    }

    public void displayRefusePotion() {
        System.out.println("Vous décidez de ne pas prendre la potion pour le moment, vous la gardez pour plus tard.");
    }

    public void displayUsePotion(Personnage personnage) {
        System.out.println("Vous avez bu une potion, vos nouveaux pv sont: " + personnage.getNiveauDeVie());

    }

    public void displayInventaireEmpty(){
        System.out.println("Votre inventaire est vide !");
    }

    // Affichage sur Case Equipment Offensif
    public void displayFindEquipmentOffensif(EquipementOffensif newArme) {
        System.out.println(newArme);
    }

    public void displayNewEquipmentOffensif(Personnage personnage) {
        System.out.println("Voici votre nouvel arme: " + personnage.getEquipementOffensif().getName() +
                "\nVotre nouvelle force d'attaque est: " + personnage.getForceDattaque());
    }

    public void displayRefuseEquipmentOffensif() {
        System.out.println("Vous aviez trouver une arme moins bonne que la votre... Vous décidez de ne pas la prendre");
    }

    public void displayNotAutorizeEquipmentOffensif() {
        System.out.println("L'arme que vous aviez trouvé n'est pas pour vous");
    }

    // Affichage sur Case Ennemi
    public void displayCombatEnCours(int ennemiLife) {
        System.out.println("L'ennemis à encore " + ennemiLife + " points de vies");
    }

    public void displayCombatVictory() {
        System.out.println("Bravo, vous avez tuer l'ennemis sans être touché");
    }

    public void displayGameOver() {
        System.out.println("Vous êtes mort");
    }

    public void displayLifeAfterCombat(Personnage personnage) {
        System.out.println("Il vous reste " + personnage.getNiveauDeVie() + " points de vies");
    }

    // Affichage Default Interaction
    public void defaultInteract() {
        System.out.println("Vous n'avez pas fait votre choix: ");
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
