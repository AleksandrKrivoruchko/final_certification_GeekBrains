import connectDb.ConnectSqlite;
import connectDb.IConnectDb;
import model.Animal;
import model.IAnimal;
import model.PetAnimal;

import java.sql.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IAnimal animal = new PetAnimal("кошка", "Дуся", "02.11.2016");
        System.out.println(animal.formatDate());
        System.out.println(animal.getAge());
        IConnectDb cs = new ConnectSqlite("my_database.db", "animal_pet");
        cs.connectDb();
//       cs.createTable();
        cs.add(animal);
        System.out.println(cs.select());
//        cs.update(1, animal);
//        System.out.println(cs.select());
        System.out.println(cs.close());

    }




}
