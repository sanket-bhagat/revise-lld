public class BillPughSingleton {
    // Private constructor
    private static BillPughSingleton instance;

    // Static inner class tohold the Singleton instance
    private static class Holder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // public method to return Singleton instance
    public static BillPughSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        BillPughSingleton s1 = BillPughSingleton.getInstance();
        BillPughSingleton s2 = BillPughSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}
