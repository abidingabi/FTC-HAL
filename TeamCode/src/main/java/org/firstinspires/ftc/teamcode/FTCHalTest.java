package org.firstinspires.ftc.teamcode;

import com.dansman805.ftchal.RobotOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import edu.wpi.first.hal.HAL;

@TeleOp
public class FTCHalTest extends RobotOpMode {
    private Robot robot = new Robot(this);

    public FTCHalTest() {
        super(HAL.Mode.TELEOP);
    }

    @Override
    protected void initOpMode() {
        robotBase = robot;
    }
}
