public class LoggerApp {
    public static void main(String[] args) {
        CustomLogger logger = CustomLogger.getInstance();
        //writing to the default file
        logger.log("this is a test message, it would go the the default log.txt file");
        logger.log("Simulation started");
        logger.log("Processing data...");
        logger.log("Simulation finished");

        //writing to a custom log file named custom_log.txt
        logger.setFileName("custom_log.txt");
        logger.log("this content should be written to the custom_log.txt file");
        logger.log("Simulation started");
        logger.log("Processing data...");
        logger.log("Simulation finished");

    }
}
