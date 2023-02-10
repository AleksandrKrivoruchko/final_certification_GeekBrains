package connectDb;

import model.IAnimal;

public interface IConnectDb extends ISQLRequest{
    boolean connectDb();
    boolean close();

}
