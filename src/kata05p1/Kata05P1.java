package kata05p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata05P1 {

    public static void main(String[] args) {
        createNewTable();
    }
    
    private static Connection connect() {
        final String url = "jdbc:sqlite:data/KATA05.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
	}
	return conn;
    }
    
    private static void createNewTable() {
	String sql = "CREATE TABLE IF NOT EXISTS email (\n"
                + "id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "direccion TEXT NOT NULL);";
        try (Connection conn = connect();
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("Tabla email creada");
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }
}