package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class TeleopDriveCommand extends Command{
    private DriveSubsystem driveSubsystem;

    public TeleopDriveCommand() {
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.tankDrive();
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stopDrive();
    }
}
