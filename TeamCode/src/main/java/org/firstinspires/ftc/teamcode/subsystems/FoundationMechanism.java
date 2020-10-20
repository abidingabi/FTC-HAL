package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants.FoundationMechanismConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FoundationMechanism extends SubsystemBase {
    private Servo leftServo;
    private Servo rightServo;

    public FoundationMechanism(HardwareMap hardwareMap) {
        leftServo =
                hardwareMap.get(Servo.class, FoundationMechanismConstants.leftFoundationConfig);
        rightServo =
                hardwareMap.get(Servo.class, FoundationMechanismConstants.rightFoundationConfig);
    }

    public void deploy() {
        leftServo.setPosition(FoundationMechanismConstants.leftDeployedPosition);
        rightServo.setPosition(FoundationMechanismConstants.rightDeployedPosition);
    }

    public void retract() {
        leftServo.setPosition(FoundationMechanismConstants.leftRetractedPosition);
        rightServo.setPosition(FoundationMechanismConstants.rightRetractedPosition);
    }
}
