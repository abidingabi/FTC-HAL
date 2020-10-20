package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.dansman805.ftchal.FTCGamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.CartesianDriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.FoundationMechanism;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class RobotContainer {
    private final DriveTrain driveTrain;
    private final FoundationMechanism foundationMechanism;
    private final Intake intake;

    private FTCGamepad primaryGamepad;
    private FTCGamepad secondaryGamepad;
    private HardwareMap hardwareMap;

    public RobotContainer(HardwareMap hardwareMap, FTCGamepad primaryGamepad,
                          FTCGamepad secondaryGamepad) {
        driveTrain = new DriveTrain(hardwareMap);
        foundationMechanism = new FoundationMechanism(hardwareMap);
        intake = new Intake(hardwareMap);

        this.primaryGamepad = primaryGamepad;
        this.secondaryGamepad = secondaryGamepad;

        driveTrain.setDefaultCommand(new CartesianDriveCommand(driveTrain,
                () -> -primaryGamepad.getX(Hand.kLeft),
                () -> primaryGamepad.getY(Hand.kLeft),
                () -> primaryGamepad.getX(Hand.kRight)));

        configureButtonBindings();
    }

    private void configureButtonBindings() {
        primaryGamepad.A
                .whenActive(foundationMechanism::retract, foundationMechanism)
                .whenInactive(foundationMechanism::deploy, foundationMechanism);

        primaryGamepad.rightBumper
                .whenPressed(intake::intake, intake)
                .whenReleased(intake::stop, intake);

        primaryGamepad.leftBumper
                .whenPressed(intake::spitOut, intake)
                .whenReleased(intake::stop, intake);
    }

    public enum AutonomousType {
        LOG,
        WAIT
    }

    private AutonomousType autonomousType = AutonomousType.LOG;

    public void setAutonomousType(AutonomousType autonomousType) {
        this.autonomousType = autonomousType;
    }

    public Command getAutonomousCommand() {
        switch (autonomousType) {
            case LOG:
                return new InstantCommand(() -> Log.d("hello", "From Log Auto"));
            case WAIT:
                return new WaitCommand(5);
            default:
                return new InstantCommand(() -> Log.d("RobotContainer",
                        "Autonomous Type is not supported"));
        }
    }
}
