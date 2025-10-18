package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommands extends Command {
    private ShooterSubsystem shooterSubsystem;

    private XboxController controller;

    public ShooterCommands(ShooterSubsystem shooterSubsystem, XboxController controller) {
        this.shooterSubsystem = shooterSubsystem;
        this.controller = controller;

        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        if (controller.getRightBumperButton()) {
            shooterSubsystem.shootBall();
            if (shooterSubsystem.getShooterSpeed() > 1200) {
                shooterSubsystem.spinIndexer();
            } else {
                shooterSubsystem.stopIndexer();
            }
        } else {
            shooterSubsystem.stopShooters();
        }

        if (controller.getXButton()) {
            shooterSubsystem.raiseShooterHood();
            if (shooterSubsystem.getHoodPosition() < -40) {
                shooterSubsystem.stopHood();
            } else {
                shooterSubsystem.raiseShooterHood();
            }
        } else {
            shooterSubsystem.stopHood();
        }

        if (controller.getBButton()) {
            shooterSubsystem.lowerShooterHood();
            if (shooterSubsystem.getHoodPosition() > -2) {
                shooterSubsystem.stopHood();
            } else {
                shooterSubsystem.lowerShooterHood();
            }
        } else {
            shooterSubsystem.stopHood();
        }
    }
}
