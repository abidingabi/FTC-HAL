package edu.wpi.first.hal;

import java.nio.ByteBuffer;

public final class HAL {
    public enum Mode {
        AUTONOMOUS,
        DISABLED,
        TELEOP,
        TEST
    }

    public static Mode mode = Mode.DISABLED;
    private static AllianceStationID allianceStationID = AllianceStationID.Blue1;

    public static void setAllianceStationID(AllianceStationID id) {
        if (allianceStationID != AllianceStationID.Blue1 &&
            allianceStationID != AllianceStationID.Blue2 &&
            allianceStationID != AllianceStationID.Red1 &&
            allianceStationID != AllianceStationID.Red2
        ) {
            throw new IllegalArgumentException(
                    "For FTC, Alliance Station ID must be one of Blue1, Blue2, Red1, or Red2!"
            );
        }

        allianceStationID = id;
    }

    public static void waitForDSData() {

    }

    public static boolean initialize(int timeout, int mode) {
        return true;
    }

    public static int kMaxJoystickAxes = 12;
    public static int kMaxJoystickPOVs = 12;


    public static short getJoystickAxes(byte joystickNum, float[] axesArray) {
        return 0;
    }

    public static short getJoystickPOVs(byte joystickNum, short[] povsArray) {
        return 0;
    }

    public static int getJoystickButtons(byte joystickNum, ByteBuffer count) {
        return 1;
    }

    public static int getMatchInfo(MatchInfoData info) {
        return 0;
    }

    public static void getControlWord(ControlWord controlWord) {
        switch (mode) {
            case AUTONOMOUS:
                controlWord.update(true, true, false, false, true, true);
                break;
            case DISABLED:
                controlWord.update(false, false, false, false, true, true);
                break;
            case TELEOP:
                controlWord.update(true, false, false, false, true, true);
                break;
            case TEST:
                controlWord.update(true, false, true, false, false, false);
                break;
        }
    }

    @SuppressWarnings("JavadocMethod")
    public static AllianceStationID getAllianceStation() {
        return allianceStationID;
    }

    public static int nativeGetControlWord() {
        return 0;
    }

    public static void report(int resource, int instanceNumber) {
        report(resource, instanceNumber, 0, "");
    }

    public static void report(int resource, int instanceNumber, int context) {
        report(resource, instanceNumber, context, "");
    }

    public static int report(int resource, int instanceNumber, int context, String feature) {
        return 0;
    }

    public static boolean hasMain() {
        return false;
    }

    public static void exitMain() {

    }


    public static void runMain() {

    }

    public static int sendError(boolean isError, int errorCode, boolean isLVCode,
                                       String details, String location, String callStack,
                                       boolean printMsg) {
        System.out.println(
                "Is Error: " + isError + "\n" +
                "Error Code: " + errorCode + "\n" +
                "Is LV Code: " + isLVCode + "\n" +
                "Details: " + details + "\n" +
                "Location: " + location + "\n" +
                "Call Stack: " + callStack + "\n" +
                "Print Message: " + printMsg);
        return 0;
    }

    public static void observeUserProgramDisabled() {

    }

    public static void observeUserProgramAutonomous() {

    }

    public static void observeUserProgramTeleop() {

    }

    public static void observeUserProgramStarting() {

    }

    public static void observeUserProgramTest() {

    }
}
