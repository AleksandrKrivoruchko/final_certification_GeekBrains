package connectDb;

import model.IAnimal;
import model.PetAnimal;
import repository.RepositoryPetAnimal;

import java.sql.*;
import java.util.Date;

public class ConnectSqlite implements IConnectDb{
    private  Connection connection;
    private Statement st;
    private String nameDb;
    private String nameTable;

    public ConnectSqlite(String nameDb, String nameTable) {
        this.nameDb = nameDb;
        this.nameTable = nameTable;
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
    public boolean createTable() {
        String sql = "CREATE TABLE " + nameTable +
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
        return true;
    }

    public boolean add(IAnimal animal) {
        String sql = "INSERT INTO " + nameTable + "(animal_name, birthday) " +
                "VALUES ('" + animal.getName() +"', '" +
                animal.formatDate() + "')";
//        System.out.println(sql);
        try {
            st = connection.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM " + nameTable +
                " WHERE id=" + id + ";";
        System.out.println(sql);
        try {
            st = connection.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public String select() {
        RepositoryPetAnimal repository = new RepositoryPetAnimal();
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + nameTable);
            while (rs.next()) {
                repository.add(rs.getInt("id"));
                String animalName = rs.getString("animal_name");
                String birthday = rs.getString("birthday");
                repository.add(new PetAnimal(animalName, birthday));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return repository.toString();
    }
}
