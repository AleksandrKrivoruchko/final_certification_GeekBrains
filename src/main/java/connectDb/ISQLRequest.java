package connectDb;

import model.IAnimal;

public interface ISQLRequest {
    boolean createTable();

    boolean add(IAnimal animal);
    boolean delete(int id);
    boolean update(int id, IAnimal animal);

    String select();
}
