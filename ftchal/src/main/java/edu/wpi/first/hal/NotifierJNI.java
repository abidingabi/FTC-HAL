package edu.wpi.first.hal;

public class NotifierJNI {
    public static int initializeNotifier() {
        return 0;
    }

    public static void setNotifierName(int notifierHandle, String name) {

    }

    public static void updateNotifierAlarm(int notifierHandle, long triggerTime) {

    }

    public static long waitForNotifierAlarm(int notifierHandle) {
        return 1;
    }
}
