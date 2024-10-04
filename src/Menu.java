import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    // lancement du programme
    public void start() {

        while (true) {
            System.out.println("Taper votre choix: (Quit ou Creer)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Quit")) {
                quit();
            } else if (choice.equalsIgnoreCase("Creer")) {
                Personnage personnage1 = createPersonnage();
                System.out.println(personnage1);
                handleModify(personnage1);
                break;
            } else {
                System.out.println("Votre choix n'est pas valide. Veuiller choisir Creer ou Quit");
            }
        }

    }

    // creer personnage (appeler par Start)
    public Personnage createPersonnage() {
        System.out.println("Ecrire votre nom:");
        String name = scanner.nextLine();

        if (name.equalsIgnoreCase("quit")) {
            quit();
        }

        System.out.println("Ecrire votre type: Guerrier ou Magicien");
        String type = scanner.nextLine();

        Personnage personnage1 = new Personnage();

        if (type.equalsIgnoreCase("quit")) {
            quit();
        } else if (isValideType(type)) {
            personnage1 = new Personnage(name, type);
        } else {
            System.out.println("Votre choix ne correspond pas à Magicien ou Guerrier, un personnage va être généré automatiquement");
            personnage1 = new Personnage(name);
        }

        return personnage1;
    }

    // modifier personnage
    public void modifyPersonnage(Personnage personnage) {

        System.out.println("Ecrire votre nom:");
        String name = scanner.nextLine();
        personnage.setName(name);


        while (true) {
            System.out.println("Ecrire votre type: Guerrier ou Magicien");
            String type = scanner.nextLine();

            if (isValideType(type) && !type.equalsIgnoreCase(personnage.getType())) {
                personnage.setType(type);
                if (type.equalsIgnoreCase("magicien")) {
                    personnage.setForceDattaque(6);
                    personnage.setNiveauDeVie(15);
                    personnage.setEquipementOffensif(new EquipementOffensif("Sort", "Eclair", 2));
                    personnage.setEquipementDefensif(new EquipementDefensif("Philtre", 3, "Philtre de défence"));
                } else if (type.equalsIgnoreCase("guerrier")) {
                    personnage.setForceDattaque(10);
                    personnage.setNiveauDeVie(10);
                    personnage.setEquipementOffensif(new EquipementOffensif("Arme", "Massue", 3));
                    personnage.setEquipementDefensif(new EquipementDefensif("Bouclier", 2, "Bouclier d'acier"));
                }
                break;
            } else {
                System.out.println("Votre choix n'est pas valide. Veuiller choisir Guerrier ou Magicien");
            }
        }
    }

    // Modifier ou Jouer ou Quitter (lancé par start)
    public void handleModify(Personnage personnage) {
        System.out.println("Voulez vous quitter ou modifier votre personnage ? Quit ou Modifier");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Modifier")) {
            modifyPersonnage(personnage);
            System.out.println(personnage);
        } /* else if (choice.equalsIgnoreCase("Jouer")) {
            play();
        } */ else {
            quit();
        }
    }

    // de quoi eviter la redondance
    public boolean isValideType(String type) {
        return type.equalsIgnoreCase("guerrier") || type.equalsIgnoreCase("magicien");
    }

    public void quit() {
        System.out.println("Fin de la partie");
        System.exit(0);
    }
}
