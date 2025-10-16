package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase{
    private VictorSP leftDriveMotor;
    private VictorSP rightDriveMotor;

    private DifferentialDrive drive;

    public DriveSubsystem(){
        leftDriveMotor = new VictorSP(Constants.LeftDrivePort);
        rightDriveMotor = new VictorSP(Constants.rightDrivePort);

        leftDriveMotor.setInverted(true);

        drive = new DifferentialDrive(leftDriveMotor::set, rightDriveMotor::set);
    }

    public void arcadeDrive(double moveRequest, double turnRequest){
        drive.arcadeDrive(moveRequest, turnRequest);
    }

    public void stopDrive() {
        leftDriveMotor.set(0);
        rightDriveMotor.set(0);
    }
}
