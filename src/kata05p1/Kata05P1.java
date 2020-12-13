package kata05p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata05P1 {

    public static void main(String[] args) {
        selectAll();
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
    
    private static void selectAll() {
	String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
		System.out.printf("Id: %d | Name: %s | Surname: %s | Departament: %s\n",
		result.getInt("Id"), result.getString("Name"),
		result.getString("Apellidos"), result.getString("Departamento"));
            }
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }
}