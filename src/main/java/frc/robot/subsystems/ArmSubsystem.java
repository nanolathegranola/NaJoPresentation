package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase{

    private final SparkFlex m_arm;

    public ArmSubsystem () {
        m_arm = new SparkFlex(1, MotorType.kBrushless);
    }

    @Override
    public void periodic() {
        
    }
    
}
