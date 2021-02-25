/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;


public class DriveCommand extends CommandBase {
  /**
   * Creates a new DriveCommand.
   */
  private Drive c_drive;
  public DoubleSupplier one;
  public DoubleSupplier two;

  public DriveCommand(Drive drive, DoubleSupplier x, DoubleSupplier y) {
    c_drive = drive;
    addRequirements(c_drive);
    one = x;
    two = y;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    c_drive.setMaxOutput(0.8);
    c_drive.setQuick(false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    c_drive.Drivecode(one.getAsDouble(), two.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
