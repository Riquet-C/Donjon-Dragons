package Case;

public class Classique implements Case {

    private String type;

    public Classique() {
        this.type = "Classique";
    }

    @Override
    public String quelCase() {
        return String.valueOf(type);
    }
}
