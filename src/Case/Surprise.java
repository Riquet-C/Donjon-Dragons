package Case;

public class Surprise implements Case {

    private String type;
    private String name;
    private int power;

    public Surprise(String nom) {
        this.type = "Surprise";
        this.name = nom;
        this.power = 2;
    }

    @Override
    public String quelCase() {
        return String.valueOf(type);
    }
}
