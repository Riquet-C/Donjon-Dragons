import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public Personnage start(){
        System.out.println("Ecrire votre nom:");
        String name = scanner.nextLine();
        System.out.println("Ecrire votre type: Guerrier ou Magicien");
        String type = scanner.nextLine();
        return new Personnage(name, type);
    }
}
