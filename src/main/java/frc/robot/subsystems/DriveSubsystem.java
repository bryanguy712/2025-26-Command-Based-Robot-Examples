package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase{
    private VictorSP leftDriveMotor = new VictorSP(Constants.LeftDrivePort);
    private VictorSP rightDriveMotor = new VictorSP(Constants.rightDrivePort);
}
