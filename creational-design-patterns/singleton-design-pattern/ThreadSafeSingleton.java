public class ThreadSafeSingleton {
    // Object declaration
    private static ThreadSafeSingleton instance;

    // Private constructor
    private ThreadSafeSingleton() {}

    // Synchronized keyword used
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingleton s1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton s2 = ThreadSafeSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}
