// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Door extends SubsystemBase {
    private DoubleSolenoid Sol3;
     //private DoubleSolenoid Sol4;
  
  /**
   * Creates a new Door.
   */
  public Door() {
    Sol3 = new DoubleSolenoid(11,2,6);
    // 11,3,7
    //Sol4 = new DoubleSolenoid(10,6,7);
  }

  public void open(){
    Sol3.set(DoubleSolenoid.Value.kReverse);
  //  Sol4.set(DoubleSolenoid.Value.kReverse);
}

public void close(){
    Sol3.set(DoubleSolenoid.Value.kForward);
   // Sol4.set(DoubleSolenoid.Value.kForward);
}
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
