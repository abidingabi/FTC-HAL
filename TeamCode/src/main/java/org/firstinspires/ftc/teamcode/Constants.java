package org.firstinspires.ftc.teamcode;

public final class Constants {
    public static final class DriveConstants {
        public static final String frontLeftConfig = "frontLeft";
        public static final String rearLeftConfig = "backLeft";
        public static final String frontRightConfig = "frontRight";
        public static final String rearRightConfig = "backRight";
    }

    public static final class FoundationMechanismConstants {
        public static final String leftFoundationConfig = "fServo2";
        public static final String rightFoundationConfig = "fServo1";
        public static final double leftDeployedPosition = 1.0;
        public static final double rightDeployedPosition = 1.0;
        public static final double leftRetractedPosition = 0.5;
        public static final double rightRetractedPosition = 0.5;
    }

    public static final class IntakeConstants {
        public static final String leftIntakeConfig = "intakeMotorLeft";
        public static final String rightIntakeConfig = "intakeMotorRight";
        public static final double intakeSpeed = 0.9;
    }
}
