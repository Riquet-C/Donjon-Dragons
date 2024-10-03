import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Taper votre choix: (Quit ou Creer)");
        String choice = scanner.nextLine();
        if (choice.equals("Quit")) {
            System.exit(0);
        }
        if (choice.equals("Creer")) {
            System.out.println(createPersonnage());
        }
    }

    public Personnage createPersonnage() {
        System.out.println("Ecrire votre nom:");
        String name = scanner.nextLine();
        System.out.println("Ecrire votre type: Guerrier ou Magicien");
        String type = scanner.nextLine();
        return new Personnage(name, type);
    }
}
