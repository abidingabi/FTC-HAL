package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.dansman805.ftchal.RobotOpMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private RobotOpMode robotOpMode;
    private RobotContainer robotContainer;
    private Command autonomousCommand;
    private boolean isAutonomousCommandTerminated = false;


    public Robot(RobotOpMode robotOpMode) {
        this.robotOpMode = robotOpMode;
    }

    @Override
    public void robotInit() {
        createRobotContainer();

//        CommandScheduler.getInstance().onCommandInitialize(command ->
//                Log.i("Command", "Command Initialized: " + command.getName()));
//        CommandScheduler.getInstance().onCommandExecute(command ->
//                Log.d("Command", "Command Executed: " + command.getName()));
//        CommandScheduler.getInstance().onCommandFinish(command ->
//                Log.i("Command", "Command Finished: " + command.getName()));
//        CommandScheduler.getInstance().onCommandInterrupt(command ->
//                Log.i("Command", "Command Interrupted: " + command.getName()));
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();

        robotOpMode.primaryGamepad.update();
        robotOpMode.secondaryGamepad.update();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = robotContainer.getAutonomousCommand()
                .andThen(() -> isAutonomousCommandTerminated = true);

        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }
    }

    @Override
    public void teleopInit() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
    }

    public void setAutonomousType(RobotContainer.AutonomousType autonomousType) {
        createRobotContainer();
        robotContainer.setAutonomousType(autonomousType);
    }

    public boolean isAutonomousCommandTerminated() {
        return isAutonomousCommandTerminated;
    }

    private void createRobotContainer() {
        if (robotContainer == null) {
            robotContainer = new RobotContainer(
                    robotOpMode.hardwareMap,
                    robotOpMode.primaryGamepad,
                    robotOpMode.secondaryGamepad);
        }
    }
}
