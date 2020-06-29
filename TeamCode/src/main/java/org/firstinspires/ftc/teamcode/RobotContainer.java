package org.firstinspires.ftc.teamcode;

import com.dansman805.ftchal.FTCGamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.CartesianDriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class RobotContainer {
    private final DriveTrain driveTrain;
    private FTCGamepad primaryGamepad;
    private FTCGamepad secondaryGamepad;
    public HardwareMap hardwareMap;

    public RobotContainer(HardwareMap hardwareMap, FTCGamepad primaryGamepad,
                          FTCGamepad secondaryGamepad) {
        driveTrain = new DriveTrain(hardwareMap);
        this.primaryGamepad = primaryGamepad;
        this.secondaryGamepad = secondaryGamepad;

        driveTrain.setDefaultCommand(new CartesianDriveCommand(driveTrain,
                () -> primaryGamepad.getX(Hand.kLeft),
                () -> -primaryGamepad.getY(Hand.kLeft),
                () -> primaryGamepad.getX(Hand.kRight)));
    }
}
