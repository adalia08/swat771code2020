/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.drive.*;


public class lime extends SubsystemBase {
  /**
   * Creates a new lime.
   */

  public NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public NetworkTableEntry tx = table.getEntry("tx");
  public NetworkTableEntry ty = table.getEntry("ty");
  double error;
  double speed;

  public double twistAndShout(){
    double x = tx.getDouble(0.0)/100;
    error = x *1.6;
    if(x>-10 && x <10){
      error = x * 3;
      return error;
    }else{
      return error;
    }
  }

  public double dance(){
    double y = ty.getDouble(0.0)/100;
    speed = y *2;
    if (y<10 && y>-10){
      speed = y * 2.8;
      return speed;
    }else{
      return speed;
    }
  }

  public boolean seek(){
    if(ty.getDouble(0.0) == 0){
      return false;
    }else{
      return true;
    }
  }
   
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
