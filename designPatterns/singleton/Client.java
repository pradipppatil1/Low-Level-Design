import java.util.*;

public class Client {

    public static void main(String[] args) {

        DbConnection dbConnection1 = DbConnection.getDlockInstance();
        DbConnection dbConnection2 = DbConnection.getDlockInstance();
        DbConnection dbConnection3 = DbConnection.getDlockInstance();
        DbConnection dbConnection4 = DbConnection.getDlockInstance();

        System.out.println("DEBUG");
        
    }

    
}