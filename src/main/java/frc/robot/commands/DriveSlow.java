/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;


public class DriveSlow extends CommandBase {
  /**
   * Creates a new DriveCommand.
   */
  private Drive c_drive;
  
  public DriveSlow(Drive drive) {
   c_drive = drive;
   addRequirements(c_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    c_drive.setMaxOutput(0.2); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    c_drive.setMaxOutput(0.8);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
