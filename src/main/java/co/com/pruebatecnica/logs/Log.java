package co.com.pruebatecnica.logs;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Log {
    private Log() {
    }

    private static Level defaultLevel = Level.DEBUG;

    private static final String CONSOLE_LOGGER_NAME = "Console";
    private static final String CONSOLE_APPENDER_NAME = "CONSOLE_APPENDER";


    private static final String TEST_LOGFILE_NAME = "Logs/TestLog.log";
    private static final String TEST_LOGGER_NAME = "Test";
    private static final String TESTS_APPENDER_NAME = "TEST_APPENDER";


    private static final LoggerContext context = (LoggerContext) LogManager.getContext(false);
    private static final Configuration logConfiguration = context.getConfiguration();
    private static ConsoleAppender consoleAppender = null;
    private static final AppenderRef refConsole = AppenderRef.createAppenderRef(CONSOLE_APPENDER_NAME, defaultLevel, null);


    public static final Logger LOGGER = LogManager.getLogger(TEST_LOGGER_NAME); // Insatancia log

    public static class CustomLevels {
        private CustomLevels() {
        }

        public static final Level COMPLETED = Level.forName("COMPLETED", 250);
        public static final Level FAILED = Level.forName("FAILED", 250);
        public static final Level PASSED = Level.forName("PASSED", 250);
        public static final Level PENDING = Level.forName("PENDING", 250);
    }

    public static void initLogs(Path evidenceDirectory, String projectFolder) {

        PatternLayout layout = createPattern();
        configureBasicLoggers(evidenceDirectory, projectFolder, layout);
        context.updateLoggers();
    }

    private static void configureBasicLoggers(Path evidenceDirectory, String projectFolder, PatternLayout layout) {
        consoleAppender = createConsoleAppender(layout);
        LoggerConfig consoleConfig = createConsoleLogger(consoleAppender);
        logConfiguration.addLogger(CONSOLE_LOGGER_NAME, consoleConfig);
        logConfiguration.addAppender(consoleAppender);

        FileAppender testAppender = createTestAppender(layout, evidenceDirectory, projectFolder);
        LoggerConfig testConfig = createTestLogger(testAppender);
        logConfiguration.addAppender(testAppender);
        logConfiguration.addLogger(TEST_LOGGER_NAME, testConfig);
    }


    public static PatternLayout createPattern() {
        String logPattern = "%d{yyyy-MMM-dd HH:mm:ss} [%logger{36}] %-5level : %msg%n%throwable";
        return PatternLayout.newBuilder()
                .withPattern(logPattern)
                .withConfiguration(logConfiguration)
                .withCharset(StandardCharsets.UTF_8)
                .withAlwaysWriteExceptions(false)
                .build();
    }

    public static ConsoleAppender createConsoleAppender(PatternLayout layout) {
        ConsoleAppender console = ConsoleAppender.newBuilder()
                .setName(CONSOLE_APPENDER_NAME)
                .withImmediateFlush(true)
                .setIgnoreExceptions(false)
                .withBufferedIo(true)
                .withBufferSize(4000)
                .setLayout(layout)
                .setConfiguration(logConfiguration)
                .build();
        console.start();
        return console;
    }

    public static LoggerConfig createConsoleLogger(ConsoleAppender console) {
        AppenderRef[] refsConsole = new AppenderRef[]{refConsole};
        LoggerConfig consoleConfig = LoggerConfig.createLogger(false, Level.INFO, CONSOLE_LOGGER_NAME, null, refsConsole, null, logConfiguration, null);
        consoleConfig.addAppender(console, defaultLevel, null);
        return consoleConfig;
    }

    public static FileAppender createTestAppender(PatternLayout layout, Path evidenceDirectory, String projectFolder) {
        FileAppender test = FileAppender.newBuilder()
                .withFileName(evidenceDirectory.resolve(projectFolder).resolve(TEST_LOGFILE_NAME).toString())
                .withAdvertise(true)
                .withLocking(false)
                .setName(TESTS_APPENDER_NAME)
                .withImmediateFlush(true)
                .setIgnoreExceptions(false)
                .withBufferedIo(true)
                .withBufferSize(4000)
                .withAdvertise(false)
                .withLayout(layout)
                .setConfiguration(logConfiguration)
                .build();
        test.start();
        return test;
    }

    public static LoggerConfig createTestLogger(FileAppender testAppender) {
        AppenderRef refTest = AppenderRef.createAppenderRef(TESTS_APPENDER_NAME, defaultLevel, null);
        AppenderRef[] refsTest = new AppenderRef[]{refTest, refConsole};
        LoggerConfig testsConfig = LoggerConfig.createLogger(false, Level.DEBUG, TEST_LOGGER_NAME, "true", refsTest, null, logConfiguration, null);
        testsConfig.addAppender(testAppender, defaultLevel, null);
        testsConfig.addAppender(consoleAppender, defaultLevel, null);
        return testsConfig;
    }


    public static AppenderRef getRefConsole() {
        return refConsole;
    }

    public static LoggerContext getContext() {
        return context;
    }

    public static Configuration getLogConfiguration() {
        return logConfiguration;
    }

    public static ConsoleAppender getConsoleAppender() {
        return consoleAppender;
    }

    public static Level getDefaultLevel() {
        return defaultLevel;
    }

    public static void setDefaultLevel(Level defaultLevel) {
        Log.defaultLevel = defaultLevel;
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

}
