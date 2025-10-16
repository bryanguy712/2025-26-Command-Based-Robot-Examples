// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
  private XboxController controller = new XboxController(Constants.mainControllerPort);

  private DriveSubsystem driveSubsystem = new DriveSubsystem();
  private TeleopDriveCommand teleopDrive = new TeleopDriveCommand(driveSubsystem, controller);

  public RobotContainer() {
    configureBindings();
    driveSubsystem.setDefaultCommand(teleopDrive);
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
