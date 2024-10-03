public class Personnage {

    private String name;
    private String type;

    public Personnage() {
        this("Toto");
    }

    public Personnage(String name) {
        this(name, "guerrier");
    }

    public Personnage(String name, String type) {
       this.name = name;
       this.type = type;
    }

}
