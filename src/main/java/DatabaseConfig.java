import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    // we use env ik. but welp. dis java. and i dont like it, and it's a learning project.
    // remember kids, always use env vards for creds. im just being lazy rn because this project doesnt matter much. 
    // the best practice is to not let ppl access ur secret sauce creds. ALWAYS. ciao!
    private static final String URL = "jdbc:postgresql://ep-dawn-resonance-a1m7xvah-pooler.ap-southeast-1.aws.neon.tech/neondb?sslmode=require";
    private static final String USER = "neondb_owner";
    private static final String PASSWORD = "npg_rhYLjKv6SZ1y";

    /**
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found. Add it to your build path.");
            e.printStackTrace();
            throw new SQLException(e);
        }
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connected to the Neon PostgreSQL database successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
