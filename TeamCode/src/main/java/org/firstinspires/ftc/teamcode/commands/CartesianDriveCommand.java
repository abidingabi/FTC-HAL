package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class CartesianDriveCommand extends CommandBase {
    private final DriveTrain driveTrain;
    private final DoubleSupplier ySpeedSupplier;
    private final DoubleSupplier xSpeedSupplier;
    private final DoubleSupplier zRotationSupplier;

    public CartesianDriveCommand(DriveTrain driveTrain, DoubleSupplier ySpeedSupplier,
                                 DoubleSupplier xSpeedSupplier, DoubleSupplier zRotationSupplier) {
        this.driveTrain = driveTrain;
        this.ySpeedSupplier = ySpeedSupplier;
        this.xSpeedSupplier = xSpeedSupplier;
        this.zRotationSupplier = zRotationSupplier;

        addRequirements(this.driveTrain);
    }

    @Override
    public void execute() {
        driveTrain.driveCartesian(ySpeedSupplier.getAsDouble(),
                xSpeedSupplier.getAsDouble(),
                zRotationSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}
