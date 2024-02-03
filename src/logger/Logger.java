package logger;

public class Logger {

    private static volatile Logger logger;
    private static AbstractLogger chain;

    private Logger(){}

    public static Logger getInstance() {
        if(logger == null) {
            synchronized (Logger.class) {
                if(logger == null) {
                    logger = new Logger();
                    AbstractLogger info = new InfoLogger();
                    AbstractLogger warn = new WarnLogger();
                    AbstractLogger debug = new DebugLogger();
                    info.setNextLogger(warn);
                    warn.setNextLogger(debug);
                    chain = info;
                }
            }
        }
        return logger;
    }

    public void info(String message) {
        chain.logMessage(0,  message);
    }

    public void warn(String message) {
        chain.logMessage(1, message);
    }

    public void debug(String message) {
        chain.logMessage(2, message);
    }
}
