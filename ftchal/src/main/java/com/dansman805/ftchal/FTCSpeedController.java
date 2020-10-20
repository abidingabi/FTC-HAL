package com.dansman805.ftchal;

import edu.wpi.first.wpilibj.SpeedController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import java.util.function.DoubleSupplier;

public class FTCSpeedController implements SpeedController {
    private double speed;
    private boolean isInverted = false;
    private DcMotorSimple motor;
    private DoubleSupplier voltageSupplier;

    public FTCSpeedController(DcMotorSimple motor, DoubleSupplier voltageSupplier) {
        this.motor = motor;
        this.voltageSupplier = voltageSupplier;
    }

    public FTCSpeedController(DcMotorSimple motor) {
        this.motor = motor;
        this.voltageSupplier = null;
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
        if (this.voltageSupplier == null) {
            throw new IllegalArgumentException("To use setVoltage, a (non-null) voltageSupplier must be passed in the constructor");
        }

        set(outputVolts / voltageSupplier.getAsDouble());
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