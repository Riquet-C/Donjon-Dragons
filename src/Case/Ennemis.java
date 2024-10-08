package Case;

public class Ennemis implements Case {

    private int attaque;
    private int life;
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getAttaque() {
        return attaque;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }



    public Ennemis(String nom) {
        this.type = "Ennemis";
        this.name = nom;
        this.attaque = 2;
        this.life = 9;
    }

    @Override
    public String quelCase() {
        return String.valueOf(type);
    }
}
