package connectDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSqlite implements IConnectDb{
    private  Connection connection;
    private Statement st;
    private String nameDb;
    private String nameTable;

    public ConnectSqlite(String nameDb) {
        this.nameDb = nameDb;
    }

    public boolean connectDb() {
        String conStr = "jdbc:sqlite:" + nameDb;
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(conStr);
            if (conn != null) {
                connection = conn;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean close() {
        if(connection == null) {
            return false;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean createTable(String table) {
        String sql = "CREATE TABLE " + table +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "animal_name TEXT NOT NULL, " +
                "birthday TEXT NOT NULL)";
        try {
            st = connection.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        nameTable = table;
        return true;
    }
}
