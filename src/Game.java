import equipement.Arme;
import equipement.EquipementDefensif;
import equipement.EquipementOffensif;
import personnage.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import Case.*;

public class Game {

    private List<Case> plateau;

    private final Personnage joueur;
    private int positionJoueur;
    private final Menu menu;

    public Game(Personnage personnage) {
        menu = new Menu();
        plateau = new ArrayList<>();
        addToPlateau();
        this.joueur = personnage;
        this.positionJoueur = -1;
    }

    public void addToPlateau() {
        plateau.add(0, new Classique());
        plateau.add(1, new Ennemis("Sorcier"));
        plateau.add(2, new Surprise("Potion"));
        plateau.add(3, new Arme("Arme", "massue", 3));
    }

    public void play() {
        while (positionJoueur < plateau.size()) {

            int valueDice = this.dice(1);
            positionJoueur += valueDice;

            Case cestQuelSurprise = plateau.get(positionJoueur);
            menu.displayAvancement(valueDice, positionJoueur, joueur);

            switch (cestQuelSurprise.quelCase()) {
                case "Classique":
                    System.out.println("Il n'y a rien ici, poursuivons !");
                    break;
                case "Ennemis":
                    Ennemis ennemi = (Ennemis) cestQuelSurprise; // Cast pour accéder aux méthodes d'Ennemis
                    System.out.println("Un ennemi est ici, il s'agit d'un " + ennemi.getName() + " il a " + ennemi.getLife() + " pv et " + ennemi.getAttaque() + " point d'attaque");
                    isEnnemy(joueur, ennemi);
                    break;
                case "Surprise":
                    Surprise surprise = (Surprise) cestQuelSurprise;
                    System.out.println("Vous avez activée une surprise : PotionElle vous apporte: 2 d'attaque supplémentaire");
                    break;
                case "Arme":
                    Arme arme = (Arme) cestQuelSurprise;
                    System.out.println("Vous avez trouvé une arme");
                    isArme(joueur, arme);
                    break;
            }
        }
    }

    public int dice(int diceLenght) {
        Random dice = new Random();
        return dice.nextInt(diceLenght) + 1;
    }

    public void isEnnemy(Personnage personnage, Ennemis ennemis) {
        ennemis.setLife(ennemis.getLife() - personnage.getForceDattaque());
        if (ennemis.getLife() > 0) {
            personnage.setNiveauDeVie(personnage.getNiveauDeVie() - ennemis.getAttaque());
            System.out.println("L'ennemis à encore " + ennemis.getLife() + " points de vies");
            System.out.println("Il vous reste " + personnage.getNiveauDeVie() + " points de vies");
        } else {
            plateau.set(positionJoueur, new Classique());
            System.out.println("Bravo, vous avez tuer l'ennemis");
        }
    }

    public void isArme(Personnage personnage, Arme arme) {

        EquipementOffensif armePersonnage = personnage.getEquipementOffensif();

        if (Objects.equals(personnage.getType(), "Guerrier")) {
            if (armePersonnage.getNiveauAttaque() < arme.getNiveauAttaque()) {
                armePersonnage.setNiveauAttaque(arme.getNiveauAttaque());
                armePersonnage.setName(arme.getName());
                armePersonnage.setType(arme.getType());
                System.out.println(arme);
            }
        }

    }
}
