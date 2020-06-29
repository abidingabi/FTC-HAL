package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.dansman805.ftchal.FTCGamepad;
import com.dansman805.ftchal.RobotOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private RobotOpMode robotOpMode;
    private RobotContainer robotContainer;


    public Robot(RobotOpMode robotOpMode) {
        this.robotOpMode = robotOpMode;
    }

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer(
                robotOpMode.hardwareMap,
                robotOpMode.primaryGamepad,
                robotOpMode.secondaryGamepad);
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();

        robotOpMode.primaryGamepad.update();
        robotOpMode.secondaryGamepad.update();
    }
}
