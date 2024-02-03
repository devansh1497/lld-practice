package logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.info("App started");
        logger.warn("Couldn't find entry in cache. Will make db call");
        logger.debug("Took 100ms for db query");
    }
}
