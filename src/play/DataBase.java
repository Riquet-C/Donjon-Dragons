package play;

import character.Personnage;

import java.sql.*;

public class DataBase {
    String url = "jdbc:mysql://localhost:3306/donjondragon";
    String username = "root";
    String password = "";

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void getHero() {
        String sql = "select * from hero";

        try (Connection con = connection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
           while (rs.next()) {
               String name = rs.getString("Nom");
               String type = rs.getString("Type");
               int niveauVie = rs.getInt("NiveauVie");
               int niveauForce = rs.getInt("NiveauForce");
               String armeSort = rs.getString("ArmeSort");
               String bouclier = rs.getString("Bouclier");

               System.out.println("Héros trouvé :");
               System.out.println("Nom : " + name);
               System.out.println("Type : " + type);
               System.out.println("Points de vie : " + niveauVie);
               System.out.println("Force d'attaque : " + niveauForce);
               System.out.println("ArmeSort : " + armeSort);
               System.out.println("Bouclier : " + bouclier);
               System.out.println("------------------------------");
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createHero(Personnage character) {
        String sql = "INSERT INTO hero (Type, Nom, NiveauVie, NiveauForce, ArmeSort, Bouclier) VALUES (?,?,?,?,?,?)";

        try (Connection con = connection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, character.getType());
            pstmt.setString(2, character.getName());
            pstmt.setInt(3, character.getLifePoints());
            pstmt.setInt(4, character.getAttackForce());
            pstmt.setString(5, character.getOffensiveEquipment() != null ? character.getOffensiveEquipment().getName() : null);
            pstmt.setString(6, character.getDefensiveEquipment() != null ? character.getDefensiveEquipment().getName() : null);

            pstmt.executeUpdate();
            System.out.println("Personnage ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du personnage : " + e.getMessage());
            e.printStackTrace();
        }
    }


//    Connection con = DriverManager.getConnection(url, username, password);
//    Statement stmt = con.createStatement();
//    ResultSet rs = stmt.executeQuery(sql)
}
