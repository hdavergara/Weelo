package co.com.pruebatecnica.helpers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    static {
        System.setProperty("logFilenameTest", Log.INITIAL_PATH + Log.NAME_LOG_TEST);
        System.setProperty("logFilenameEvidences", Log.INITIAL_PATH + Log.NAME_LOG_EVIDENCES);
        System.setProperty("logFilenameBusiness", Log.INITIAL_PATH + Log.NAME_LOG_BUSINESS);
        org.apache.logging.log4j.core.LoggerContext ctx =
                (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        ctx.reconfigure();
    }

    private static final String INITIAL_PATH = "c:/tmp";
    private static final String NAME_LOG_TEST = "/Logs/TestLog.log";
    private static final String NAME_LOG_BUSINESS = "/Logs/BusinessLog.log";
    private static final String NAME_LOG_EVIDENCES = "/Logs/EvidenceLog.log";

    public static final Logger LOGGER = LogManager.getLogger("Test");
    public static final Logger LOGGER_EVIDENCES = LogManager.getLogger("Evidences");
    public static final Logger LOGGER_BUSINESS = LogManager.getLogger("Business");

    public static class CustomLevels {
        public static final Level COMPLETED = Level.forName("COMPLETED", 250);
        public static final Level FAILED = Level.forName("FAILED", 250);
        public static final Level PASSED = Level.forName("PASSED", 250);
        public static final Level PENDING = Level.forName("PENDING", 250);
    }
}
