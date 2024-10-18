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

    public void getHero(String choice, Personnage character) {
        String sql = "select * from hero WHERE Nom = ?";

        try (Connection con = connection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, choice);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("Nom");
                    String type = rs.getString("Type");
                    int niveauVie = rs.getInt("NiveauVie");
                    int niveauForce = rs.getInt("NiveauForce");
                    String armeSort = rs.getString("ArmeSort");
                    String bouclier = rs.getString("Bouclier");

                    character.setName(name);
                    character.setType(type);
                    character.setLifePoints(niveauVie);
                    character.setAttackForce(niveauForce);

                    if (armeSort != null) {
                        character.setOffensiveEquipment(armeSort);
                    }

                    if (bouclier != null) {
                        character.setDefensiveEquipment(bouclier);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createHero(Personnage character) {
        String sql = "INSERT INTO hero (Type, Nom, NiveauVie, NiveauForce, ArmeSort, Bouclier) VALUES (?,?,?,?,?,?)";

        try (Connection con = connection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            valuesDataTable(character, pstmt);
            System.out.println("Personnage ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du personnage : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void editHero(Personnage character) {
      String sql = "UPDATE hero SET Type = ?, Nom = ?, NiveauVie = ?, NiveauForce = ?, ArmeSort = ?, Bouclier = ? WHERE id = (SELECT MAX(id) FROM (SELECT id FROM hero) AS temp)";
        try (Connection con = connection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            valuesDataTable(character, pstmt);
            System.out.println("Modification effectué avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du personnage : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void changeDuringGame(Personnage character) {
        // String sql = "UPDATE hero SET NiveauVie = ?, ArmeSort = ? WHERE Nom = ?";
        String sql1 = (character.getLifePoints() <= 0) ? "DELETE FROM hero WHERE Nom = ?" : "UPDATE hero SET NiveauVie = ?, ArmeSort = ? WHERE Nom = ?";

        try (Connection con = connection(); PreparedStatement pstmt = con.prepareStatement(sql1)) {
            if (character.getLifePoints() > 0) {
                pstmt.setInt(1, character.getLifePoints() != 0 ? character.getLifePoints() : 0);
                pstmt.setString(2, character.getOffensiveEquipment() != null ? character.getOffensiveEquipment().getName() : null);
                pstmt.setString(3, character.getName());

                pstmt.executeUpdate();
            } else {
                pstmt.setString(1, character.getName());
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du niveau de vie du personnage : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void valuesDataTable(Personnage character, PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, character.getType());
        pstmt.setString(2, character.getName());
        pstmt.setInt(3, character.getLifePoints());
        pstmt.setInt(4, character.getAttackForce());
        pstmt.setString(5, character.getOffensiveEquipment() != null ? character.getOffensiveEquipment().getName() : null);
        pstmt.setString(6, character.getDefensiveEquipment() != null ? character.getDefensiveEquipment().getName() : null);

        pstmt.executeUpdate();
    }
}
