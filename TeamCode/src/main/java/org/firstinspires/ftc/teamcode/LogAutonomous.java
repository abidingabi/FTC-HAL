package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.dansman805.ftchal.RobotOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj2.command.InstantCommand;

@Autonomous
public class LogAutonomous extends RobotOpMode {
    private Robot robot = new Robot(this);

    public LogAutonomous() {
        super(HAL.Mode.AUTONOMOUS);
    }

    @Override
    protected void initOpMode() {
        robotBase = robot;
        robot.setAutonomousType(RobotContainer.AutonomousType.LOG);
        shouldTerminate = robot::isAutonomousCommandTerminated;
    }
}
