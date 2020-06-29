package org.firstinspires.ftc.teamcode.subsystems;

import com.dansman805.ftchal.FTCSpeedController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import static org.firstinspires.ftc.teamcode.Constants.DriveConstants;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private final SpeedController frontLeft;
    private final SpeedController rearLeft;
    private final SpeedController frontRight;
    private final SpeedController rearRight;

    private MecanumDrive drive;

    public DriveTrain(HardwareMap hardwareMap) {
        frontLeft = new FTCSpeedController(
                hardwareMap.get(DcMotorSimple.class, DriveConstants.frontLeftConfig));

        rearLeft = new FTCSpeedController(
                hardwareMap.get(DcMotorSimple.class, DriveConstants.rearLeftConfig));

        frontRight = new FTCSpeedController(
                hardwareMap.get(DcMotorSimple.class, DriveConstants.frontRightConfig));

        rearRight = new FTCSpeedController(
                hardwareMap.get(DcMotorSimple.class, DriveConstants.rearRightConfig));

        drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    }

    @Override
    public void periodic() {

    }

    public void drivePolar(double magnitude, double angle, double zRotation) {
        drive.drivePolar(magnitude, angle, zRotation);
    }

    public void driveCartesian(double ySpeed, double xSpeed, double zRotation) {
        drive.driveCartesian(ySpeed, xSpeed, zRotation);
    }

    public void stop() {
        drive.stopMotor();
    }
}
