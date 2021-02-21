package com.framework.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

    private static Logger logger = LogManager.getLogger(LoggerTest.class);
    public static void main(String[] args) {

        logger.info("INFO - logger");
        logger.error("error - logger");
        logger.debug("debug - logger");
        logger.fatal("fatal - logger");
        logger.trace("trace - logger");
        logger.warn("warn - logger");

    }

    public void configureLogOnConsoleProgrammatically(){
        /*ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

        builder.setStatusLevel(Level.DEBUG);
// naming the logger configuration
        builder.setConfigurationName("DefaultLogger");

// create a console appender
        AppenderComponentBuilder appenderBuilder = builder.newAppender("Console", "CONSOLE")
                .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
// add a layout like pattern, json etc
        appenderBuilder.add(builder.newLayout("PatternLayout")
                .addAttribute("pattern", "%d %p %c [%t] %m%n"));
        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(Level.DEBUG);
        rootLogger.add(builder.newAppenderRef("Console"));

        builder.add(appenderBuilder);
        builder.add(rootLogger);
        Configurator.reconfigure(builder.build());

        Logger log = (Logger) LogManager.getLogger();
        log.info("I am a logger test!!");*/
    }

}
