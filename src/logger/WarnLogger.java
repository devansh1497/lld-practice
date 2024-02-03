package logger;

public class WarnLogger extends AbstractLogger {
    @Override
    public void setLevel(int level) {
        this.level = 1;
    }
    @Override
    void display(String message) {
        System.out.println("WARN: " + message);
    }
}
