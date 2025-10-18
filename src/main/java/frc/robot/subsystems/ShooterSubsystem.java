package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase{
    private SparkMax shooterA;
    private SparkMax shooterB;
    private SparkMax shooterIndexer;
    private SparkMax shooterHood;

    public ShooterSubsystem() {
        shooterA = new SparkMax(Constants.shooterAPort, MotorType.kBrushless);
        shooterB = new SparkMax(Constants.shooterBPort, MotorType.kBrushless);

        shooterA.configure(new SparkMaxConfig().inverted(false), ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        shooterB.configure(new SparkMaxConfig().inverted(true).follow(shooterA), ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

        shooterIndexer = new SparkMax(Constants.shooterIndexerPort, MotorType.kBrushless);

        shooterHood = new SparkMax(Constants.shooterHoodPort, MotorType.kBrushless);
    }

    public void shootBall() {
        shooterA.setVoltage(4);
    }

    public void spinIndexer() {
        shooterIndexer.setVoltage(3);
    }

    public void raiseShooterHood() {
        shooterHood.setVoltage(2);
    }

    public void lowerShooterHood() {
        shooterHood.setVoltage(-2);
    }

    public void stopHood() {
        shooterHood.setVoltage(0);
    }

    public void stopShooters() {
        shooterA.setVoltage(0);
        shooterB.setVoltage(0);
    }

    public void stopIndexer() {
        shooterIndexer.setVoltage(0);
    }

    public double getHoodPosition() {
        return shooterHood.getEncoder().getPosition();
    }

    public double getShooterSpeed() {
        return shooterA.getEncoder().getVelocity();
    }
}
