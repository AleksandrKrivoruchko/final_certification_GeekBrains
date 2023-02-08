package connectDb;

public interface IConnectDb {
    boolean connectDb();
    boolean close();
    boolean createTable(String table);
}
