package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase{
    private VictorSP leftDriveMotor = new VictorSP(Constants.LeftDrivePort);
    private VictorSP rightDriveMotor = new VictorSP(Constants.rightDrivePort);

    private XboxController controller = new XboxController(Constants.controllerPort);

    private DifferentialDrive drive = new DifferentialDrive(leftDriveMotor::set, rightDriveMotor::set);

    public DriveSubsystem(){
        leftDriveMotor.setInverted(true);
    }

    public void tankDrive(){
        drive.tankDrive(-controller.getLeftY(), -controller.getRightX());
    }

    public void stopDrive() {
        drive.stopMotor();
    }
}
