public class Singleton {


    private static Singleton INSTANCE;
    private static final Object mutex = new Object();

    private Singleton(){}

    public static Singleton create() {
        if(INSTANCE == null) {
            synchronized (mutex) {
                if(INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
