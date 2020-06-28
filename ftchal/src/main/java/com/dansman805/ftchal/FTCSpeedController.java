package com.dansman805.ftchal;

import edu.wpi.first.wpilibj.SpeedController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class FTCSpeedController implements SpeedController {
    private double speed;
    private boolean isInverted = false;
    private DcMotorSimple motor;


    public FTCSpeedController(DcMotorSimple motor) {
        this.motor = motor;
    }

    @Override
    public void set(double speed) {
        this.speed = isInverted ? -speed : speed;
        motor.setPower(this.speed);
    }

    @Deprecated
    @Override
    // I don't think there's a good way to get battery voltage, so this is deprecated
    public void setVoltage(double outputVolts) {
        set(outputVolts / 12.0);
    }

    @Override
    public double get() {
        return speed;
    }

    @Override
    public void setInverted(boolean inverted) {
        isInverted = inverted;
    }

    @Override
    public boolean getInverted() {
        return isInverted;
    }

    @Override
    public void disable() {
        set(0);
    }

    @Override
    public void stopMotor() {
        set(0);
    }

    @Override
    public void pidWrite(double output) {
        set(output);
    }
}