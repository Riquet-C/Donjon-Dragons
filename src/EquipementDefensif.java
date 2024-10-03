public class EquipementDefensif {
    private String type;
    private int niveauDefence;
    private String name;


    public EquipementDefensif() {
        this("Bouclier");
    }

    public EquipementDefensif(String type) {
        this(type, 4);
    }

    public EquipementDefensif(String type, int niveauDefence) {
        this(type, niveauDefence, "Bouclier en acier");
    }

    public EquipementDefensif(String type, int niveauDefence, String name) {
        this.type = type;
        this.niveauDefence = niveauDefence;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getniveauDefence() {
        return niveauDefence;
    }

    public void setniveauDefence(int niveauDefence) {
        this.niveauDefence = niveauDefence;
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
                "niveau de défence: +" + niveauDefence;
    }

}
