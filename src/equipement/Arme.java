package equipement;
import Case.*;

public class Arme extends EquipementOffensif implements Case {

    public Arme(String type, String name, int attaque) {
        this.setType(type);
        this.setName(name);
        this.setNiveauAttaque(attaque);
    }

    @Override
    public String quelCase() {
        return this.getType();
    }
}
