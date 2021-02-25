// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

 package frc.robot.commands;

 import edu.wpi.first.wpilibj2.command.CommandBase; 
import frc.robot.subsystems.*;



public class IntakeKill extends CommandBase {
  
  private Intake c_Intake;
  
    /**
     * Creates a new IntakeKill.
     * 
     */
    public IntakeKill(Intake intake) {
    c_Intake = intake;
    addRequirements(c_Intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public IntakeKill() {
      
	}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   c_Intake.kill();

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
