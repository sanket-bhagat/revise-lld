public class DoubleCheckedLockingSingleton {
    // Volitile object declaration
    private static volatile DoubleCheckedLockingSingleton instance;

    // Private constructor
    private DoubleCheckedLockingSingleton() {}

    // Thread-safe method using double-checked locking
    public static synchronized DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckedLockingSingleton s1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton s2 = DoubleCheckedLockingSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}
