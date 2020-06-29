package com.dansman805.ftchal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.robot.Robot;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.RobotBase;

public abstract class RobotOpMode extends LinearOpMode {
    protected RobotBase robotBase;
    private HAL.Mode mode;

    public FTCGamepad primaryGamepad;
    public FTCGamepad secondaryGamepad;

    public RobotOpMode(HAL.Mode mode) {
        this.mode = mode;
    }

    private Thread robotBaseRunner = new Thread(() -> {
        RobotBase.startRobot(() -> robotBase);
    });

    @Override
    public void runOpMode() throws InterruptedException {
        primaryGamepad = new FTCGamepad(gamepad1);
        secondaryGamepad = new FTCGamepad(gamepad2);

        initOpMode();

        robotBaseRunner.start();

        waitForStart();

        HAL.mode = mode;

        //noinspection StatementWithEmptyBody
        while (opModeIsActive()) { }

        startOpMode();

        HAL.mode = HAL.Mode.DISABLED;
        robotBaseRunner.interrupt();
    }

    protected void initOpMode() {

    }

    protected void startOpMode() {

    }
}
