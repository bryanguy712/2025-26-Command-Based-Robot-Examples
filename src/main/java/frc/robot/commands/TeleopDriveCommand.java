package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class TeleopDriveCommand extends Command{
    private DriveSubsystem driveSubsystem;

    private XboxController controller;

    public TeleopDriveCommand(DriveSubsystem driveSubsystem, XboxController controller) {
        this.driveSubsystem = driveSubsystem;
        this.controller = controller;

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        double moveRequest = controller.getLeftY();
        double turnRequest = controller.getRightX();
        driveSubsystem.arcadeDrive(moveRequest, turnRequest);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stopDrive();
    }
}
