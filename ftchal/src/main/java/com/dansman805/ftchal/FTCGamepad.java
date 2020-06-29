package com.dansman805.ftchal;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.HashMap;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class FTCGamepad extends XboxController {
    public final JoystickButton A;
    public final JoystickButton B;
    public final JoystickButton X;
    public final JoystickButton Y;
    public final JoystickButton leftBumper;
    public final JoystickButton rightBumper;
    public final JoystickButton Back;
    public final JoystickButton Start;
    public final JoystickButton leftStick;
    public final JoystickButton rightStick;
    public final POVButton dpad_up;
    public final POVButton dpad_right;
    public final POVButton dpad_down;
    public final POVButton dpad_left;

    private Gamepad gamepad;

    private HashMap<Button, Boolean> lastButtonState = new HashMap<>();

    private static int gamepadsInitialized = 0;

    public FTCGamepad(Gamepad gamepad) {
        super(gamepadsInitialized);
        gamepadsInitialized++;

        this.gamepad = gamepad;

        A = new JoystickButton(this, Button.kA.value);
        B = new JoystickButton(this, Button.kB.value);
        X = new JoystickButton(this, Button.kX.value);
        Y = new JoystickButton(this, Button.kY.value);
        leftBumper = new JoystickButton(this, Button.kBumperLeft.value);
        rightBumper = new JoystickButton(this, Button.kBumperRight.value);
        Back = new JoystickButton(this, Button.kBack.value);
        Start = new JoystickButton(this, Button.kStart.value);
        leftStick = new JoystickButton(this, Button.kStickLeft.value);
        rightStick = new JoystickButton(this, Button.kStickRight.value);
        dpad_up = new POVButton(this, 0);
        dpad_right = new POVButton(this, 90);
        dpad_down = new POVButton(this, 180);
        dpad_left = new POVButton(this, 270);
   }

    public void update() {
       saveButtons();
    }

    @Override
    public boolean getRawButton(int button) {
        switch (intToButton(button)) {
            case kBumperLeft:
                return gamepad.left_bumper;
            case kBumperRight:
                return gamepad.right_bumper;
            case kStickLeft:
                return gamepad.left_stick_button;
            case kStickRight:
                return gamepad.right_stick_button;
            case kA:
                return gamepad.a;
            case kB:
                return gamepad.b;
            case kX:
                return gamepad.x;
            case kY:
                return gamepad.y;
            case kBack:
                return gamepad.back;
            case kStart:
                return gamepad.start;
            default:
                return false;
        }
    }

    @Override
    public boolean getRawButtonPressed(int button) {
        boolean value = getRawButton(button);

        return (lastButtonState.get(intToButton(button)) == !value) && value;
    }

    @Override
    public boolean getRawButtonReleased(int button) {
        boolean value = getRawButton(button);

        return (lastButtonState.get(intToButton(button)) == !value) && !value;
    }

    @Override
    public double getRawAxis(int axis) {
        switch (intToAxis(axis)) {
            case kLeftX:
                return gamepad.left_stick_x;
            case kRightX:
                return gamepad.right_stick_x;
            case kLeftY:
                return gamepad.left_stick_y;
            case kRightY:
                return gamepad.right_stick_y;
            case kLeftTrigger:
                return gamepad.left_trigger;
            case kRightTrigger:
                return gamepad.right_trigger;
            default:
                return 0.0;
        }
    }

    private void saveButtons() {
        for (Button button : Button.values()) {
            lastButtonState.put(button, getRawButton(button.value));
        }
    }

    private Button intToButton(int button) {
        Button buttonEnum = null;

        for (Button buttonType : Button.values()) {
            if (buttonType.value == button) {
                buttonEnum = buttonType;
            }
        }

        return buttonEnum;
    }

    private Axis intToAxis(int axis) {
        Axis axisEnum = null;

        for (Axis axisType : Axis.values()) {
            if (axisType.value == axis) {
                axisEnum = axisType;
            }
        }

        return axisEnum;
    }
}

