// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;

public class Conveyor extends SubsystemBase {
    private WPI_TalonSRX talonSRX9;

  
  /**
   * Creates a new Conveyor.
   */
  public Conveyor() {
    talonSRX9 = new WPI_TalonSRX(9);
  }
  public void on(double speed){
        talonSRX9.set(speed);
    }
    public void kill(){
      talonSRX9.set(0);
      }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
