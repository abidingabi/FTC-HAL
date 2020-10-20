package com.dansman805.ftchal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.function.BooleanSupplier;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.RobotBase;

public abstract class RobotOpMode extends LinearOpMode {
    protected static RobotBase robotBase;
    private HAL.Mode mode;

    public FTCGamepad primaryGamepad;
    public FTCGamepad secondaryGamepad;
    protected BooleanSupplier shouldTerminate = () -> false;

    public RobotOpMode(HAL.Mode mode) {
        this.mode = mode;
    }

    private static Thread robotBaseRunner = new Thread(() -> {
        RobotBase.startRobot(() -> robotBase);
    });

    @Override
    public void runOpMode() throws InterruptedException {
        primaryGamepad = new FTCGamepad(gamepad1);
        secondaryGamepad = new FTCGamepad(gamepad2);

        if (!robotBaseRunner.isAlive()) {
            robotBaseRunner.start();
        }

        initOpMode();

        waitForStart();

        HAL.mode = mode;

        startOpMode();

        //noinspection StatementWithEmptyBody
        while (opModeIsActive() && !shouldTerminate.getAsBoolean()) { }

        HAL.mode = HAL.Mode.DISABLED;
    }

    protected void initOpMode() {

    }

    protected void startOpMode() {

    }
}
