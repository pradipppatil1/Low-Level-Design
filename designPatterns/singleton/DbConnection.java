import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DbConnection {
    
    
    String url;
    String userName;
    String password;

    private DbConnection(){

    }

    /* Option 1 with its problem
     * Below code of version is problem as during runtime
     * there are chances and getting created multiple instances
     * of instaConnection in multi threaded enviroment where instances
     * get created during runtime
    */

    private static DbConnection instaConnection = null;

    public static DbConnection getInstance() {
        if(instaConnection == null)
        {
            instaConnection = new DbConnection();
        }

        return instaConnection;
    }

    /* Option 2 Eager Loading and its problem
     * In this race condition or multiple instance creation
     * in mulithreaded enviroment fixed by creating eagerInstaConnection
     * instance during compile time
     * Issues are - We can not pass dynamic param to constructor
     * As instance created during application start, staring time increaes
     * if there are many such instances has to create and there might be 
     * case they even not be used
     
    */

    private static DbConnection eagerInstaConnection = new DbConnection();

    public static DbConnection getEagerInstance() {
         return eagerInstaConnection;
    }

    /* Option 3 use lock/Mutex/Syncronize, lazy loading
     * use Syncronize keyword in method to avoid concurrency situation
     * so only 1 thread have access at a time, which will lead to slow
     * performance
     * 
    */

    private static DbConnection syncInstaConnection = null;

    public synchronized static DbConnection getSyncInstance() {
        if(syncInstaConnection == null)
        {
            syncInstaConnection = new DbConnection();
        }

        return syncInstaConnection;
    }

    // this is production used code
    /* Option 4 use Doublelock
     * this isthe best solution to avoid concurrency situation
     * also this fix perfrmance issue also. No need of Syncronize
     * 
    */

    private static DbConnection dlockInstaConnection = null;
    public static final Lock lock = new ReentrantLock();

    public static DbConnection getDlockInstance() {

        if(dlockInstaConnection == null)
        {
            lock.lock();
                if(dlockInstaConnection == null)
                {
                    dlockInstaConnection = new DbConnection();
                }
            lock.unlock();
        }

        return dlockInstaConnection;
    }


}

