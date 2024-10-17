package play;

import java.sql.*;

/**
 * Play
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        DataBase dataBase = new DataBase();
        dataBase.getHero();
        Game game = new Game();
        game.initGame();
    }
}