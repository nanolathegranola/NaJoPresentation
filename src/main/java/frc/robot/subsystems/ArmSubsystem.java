package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.States;

public class ArmSubsystem extends SubsystemBase {

    private final SparkFlex m_arm;
    private final CANcoder encoder;
    private final PIDController pid;

    public ArmSubsystem() {
        m_arm = new SparkFlex(1, MotorType.kBrushless);
        encoder = new CANcoder(2);
        pid = new PIDController(Constants.ArmConstants.kP, Constants.ArmConstants.kI, Constants.ArmConstants.kD);

        pid.setSetpoint(States.ArmStates.STOP.degrees);
    }

    @Override
    public void periodic() {
        double degrees = Units.rotationsToDegrees(encoder.getPosition().getValueAsDouble());
        double speed = pid.calculate(degrees);
        m_arm.set(speed);
    }

}
