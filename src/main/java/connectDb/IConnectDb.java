package connectDb;

import model.IAnimal;

public interface IConnectDb {
    boolean connectDb();
    boolean close();
    boolean createTable();

    boolean add(IAnimal animal);
    boolean delete(int id);
}
