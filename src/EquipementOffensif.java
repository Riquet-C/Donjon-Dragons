import java.util.Objects;

public class EquipementOffensif {

    private String type;
    private int niveauAttaque;
    private String name;


    public EquipementOffensif() {
        this("Arme");
    }

    public EquipementOffensif(String type) {
        this(type, "Massue");
    }

    public EquipementOffensif(String type, String name) {
        this(type, name, 3);
    }

    public EquipementOffensif(String type, String name, int niveauAttaque) {
        this.type = type;
        this.niveauAttaque = niveauAttaque;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNiveauAttaque() {
        return niveauAttaque;
    }

    public void setNiveauAttaque(int niveauAttaque) {
        this.niveauAttaque = niveauAttaque;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "name: " + name + "\n" +
                "type: " + type + "\n" +
                "niveau d'attaque: +" + niveauAttaque;
    }

}
