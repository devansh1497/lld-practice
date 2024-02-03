package logger;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    void logMessage(int level, String message) {
        if(this.level >= level) {
            display(message);
        }
        if(nextLogger != null) {
            nextLogger.display(message);
        }
    }

    abstract void display(String message);
}
