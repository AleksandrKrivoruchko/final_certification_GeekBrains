import connectDb.ConnectSqlite;
import model.Animal;

import java.sql.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ConnectSqlite cs = new ConnectSqlite("my_database.db");
        cs.connectDb();
        cs.createTable("animal");
        System.out.println(cs.close());
    }




}
