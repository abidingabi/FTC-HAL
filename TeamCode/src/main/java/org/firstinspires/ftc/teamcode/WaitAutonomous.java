package org.firstinspires.ftc.teamcode;


import com.dansman805.ftchal.RobotOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import edu.wpi.first.hal.HAL;

@Autonomous
public class WaitAutonomous extends RobotOpMode {
    private Robot robot = new Robot(this);

    public WaitAutonomous() {
        super(HAL.Mode.AUTONOMOUS);
    }

    @Override
    protected void initOpMode() {
        robotBase = robot;
        robot.setAutonomousType(RobotContainer.AutonomousType.WAIT);
        shouldTerminate = robot::isAutonomousCommandTerminated;
    }
}
