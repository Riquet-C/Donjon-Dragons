package play;

import personnage.Guerriers;
import personnage.Magiciens;
import personnage.Personnage;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Menu {
    private final Scanner scanner;
    private Game game;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public String displayMenuStart(){
        System.out.println("=== Menu du Jeu ===");
        System.out.println("1. Quitter");
        System.out.println("2. Creer un personnage");
        System.out.print("Choisissez une option : ");
        return scanner.nextLine();
    }

    public String displayMenuModify(Personnage personnage){
        System.out.println("=== Menu du Jeu ===");
        System.out.println("1. Quitter");
        System.out.println("2. Modifier un personnage");
        System.out.println("3. Jouer");
        System.out.print("Choisissez une option : ");
        return scanner.nextLine();
    }

    public String displayMenuInGame(){
        System.out.println("=== Menu du Jeu ===");
        System.out.println("1. Quitter");
        System.out.println("2. Statistique du personnage");
        System.out.println("3. Continuer");
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
    public void modifyPersonnage(Personnage personnage) throws PersonnageHorsPlateauException {

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
                "'+-------+',\n" +
                        " '|       |',\n" +
                        " '|   " + valueDice + "   |',\n" +
                        " '|       |',\n" +
                        " '+-------+'");
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
                "                                          _\n" +
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

    // de quoi eviter la redondance
    public boolean isValideType(String type) {
        return type.equalsIgnoreCase("1") || type.equalsIgnoreCase("2");
    }

    public void quit() {
        System.out.println("Fin de la partie");
        System.exit(0);
    }

}
