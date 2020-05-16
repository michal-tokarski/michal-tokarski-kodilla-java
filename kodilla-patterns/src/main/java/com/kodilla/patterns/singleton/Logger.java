package com.kodilla.patterns.singleton;

public class Logger {

    private String lastLog = "";
    private static Logger loggerInstance = null; // added for singleton (static field)

    // added for singleton (making constructor private)
    private Logger() {
    }

    // added for singleton (instantiating single object)
    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        System.out.println("Last log: [" + loggerInstance.toString() + "]"); // extra
        return lastLog;
    }

    // extra
    @Override
    public String toString() {
        return lastLog;
    }

}
