import connectDb.ConnectSqlite;
import model.Animal;
import model.PetAnimal;

import java.sql.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        PetAnimal cat = new PetAnimal("Сёма", "28.12.2016");
//        System.out.println(cat.formatDate());
//        System.out.println(cat.getAge());
        ConnectSqlite cs = new ConnectSqlite("my_database.db", "animal");
        cs.connectDb();
//        cs.createTable();
//        cs.add(cat);
        System.out.println(cs.select());
        System.out.println(cs.close());

    }




}
