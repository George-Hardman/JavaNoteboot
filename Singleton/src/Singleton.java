/**
 * Singleton class is used when a class must have a single instance available.
 * <a href="https://www.youtube.com/watch?v=tSZn4wkBIu8">Youtube Video</a>
 */
public class Singleton {
    // Volatile is required to ensure that it is fully constructed before another thread can access it.
    // Volatile variables need to be accessed from the main memory, rather than cached.
    private static volatile Singleton instance;
    private String data;
    private Singleton(String data){
        this.data = data;
    }

    public static Singleton getInstance(String data){
        // Store the result in local memory to limit memory reads and increase performance.
        Singleton result = instance;
        // The Double checked locking idiom
        // This means that the synchronization is only run in the rare case that a new instance
        // needs to be created.
        if (instance == null){
            // Synchronized means this can only be run by one thread at a time (locks it)
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton(data);
                }
            }
        }
        return instance;
    }

}
