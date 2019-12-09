package com.learn_kotlin.util;

import android.util.Log;

public final class LoggerUtils {

    /**
     * Constructor to Initialize data.
     * Suppress default constructor for non-instantiation
     */
    private LoggerUtils() {
        throw new AssertionError();
    }

    /**
     * Logs an error message and error object
     *
     * @param tag       Used to identify the source of a log message. It usually identifies
     *                  the class or activity where the log call occurs.
     * @param message   The message need to be logged.
     * @param exception An exception to log.
     */
    public static void logError(String tag, String message, Exception exception) {
        Log.e(tag, message, exception);
    }

    /**
     * Logs a verbose message
     *
     * @param tag     Used to identify the source of a log message. It usually identifies
     *                the class or activity where the log call occurs.
     * @param message The message need to be logged.
     */
    public static void logVerbose(String tag, String message) {
        Log.v(tag, message);
    }

    /**
     * Logs an info message
     *
     * @param tag     Used to identify the source of a log message. It usually identifies
     *                the class or activity where the log call occurs.
     * @param message The message need to be logged.
     */
    public static void logInfo(String tag, String message) {
        Log.i(tag, message);
    }

    /**
     * Logs a debug message
     *
     * @param tag     Used to identify the source of a log message. It usually identifies
     *                the class or activity where the log call occurs.
     * @param message The message need to be logged.
     */
    public static void logDebug(String tag, String message) {
        Log.d(tag, message);
    }

    /**
     * Logs a warning message
     *
     * @param tag     Used to identify the source of a log message. It usually identifies
     *                the class or activity where the log call occurs.
     * @param message The message need to be logged.
     */
    public static void logWarn(String tag, String message) {
        Log.w(tag, message);
    }
}
