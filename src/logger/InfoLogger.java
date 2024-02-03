package logger;

public class InfoLogger extends AbstractLogger {
    @Override
    public void setLevel(int level) {
        this.level = 0;
    }
    @Override
    void display(String message) {
        System.out.println("INFO: " + message);

    }
}
