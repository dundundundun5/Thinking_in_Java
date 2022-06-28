package strings;

public class DatabaseException extends Exception{
    public DatabaseException(int transactionID, int queryId, String message) {
        //String.format()可生产格式化的String对象
        super(String.format("(t%d, q%d) %s", transactionID, queryId, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch (DatabaseException e) {
            System.out.println(e);
        }
    }
}
