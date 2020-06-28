package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.RobotBase;

@TeleOp
public class FTCHalTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotBase.startRobot(Robot::new);

        waitForStart();

        HAL.mode = HAL.Mode.TELEOP;

        //noinspection StatementWithEmptyBody
        while (opModeIsActive()) { }

        HAL.mode = HAL.Mode.DISABLED;
    }
}
