package org.firstinspires.ftc.teamcode.subsystems;

import com.dansman805.ftchal.FTCSpeedController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private SpeedController leftIntake;
    private SpeedController rightIntake;

    public Intake(HardwareMap hardwareMap) {
        leftIntake = new FTCSpeedController(
                hardwareMap.get(DcMotor.class, IntakeConstants.leftIntakeConfig));

        rightIntake = new FTCSpeedController(
                hardwareMap.get(DcMotor.class, IntakeConstants.rightIntakeConfig));

        leftIntake.setInverted(true);
    }

    public void intake() {
        leftIntake.set(IntakeConstants.intakeSpeed);
        rightIntake.set(IntakeConstants.intakeSpeed);
    }

    public void spitOut() {
        leftIntake.set(-IntakeConstants.intakeSpeed);
        rightIntake.set(-IntakeConstants.intakeSpeed);
    }

    public void stop() {
        leftIntake.stopMotor();
        rightIntake.stopMotor();
    }
}
