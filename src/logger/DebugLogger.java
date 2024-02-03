package logger;

public class DebugLogger extends AbstractLogger {
    @Override
    public void setLevel(int level) {
        this.level = 2;
    }

    @Override
    void display(String message) {
        System.out.println("DEBUG: " + message);

    }
}
