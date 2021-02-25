/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

 package frc.robot.subsystems;

 import edu.wpi.first.wpilibj2.command.SubsystemBase;
 import edu.wpi.first.wpilibj.DoubleSolenoid;
 import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.*;
 import edu.wpi.first.wpilibj.DriverStation;
 import com.revrobotics.*;            
 import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

 public class Wheel extends SubsystemBase {
   private DoubleSolenoid Sol5;
   private final I2C.Port i2cp = I2C.Port.kOnboard;
   private final ColorSensorV3 coolour = new ColorSensorV3(i2cp);
   private final ColorMatch coolourMatch = new ColorMatch();

   private final Color blu = coolourMatch.makeColor(0.14, 0.42, 0.43);
   private final Color grass = coolourMatch.makeColor(0.19, 0.56, 0.24);
   private final Color bestCoolour = coolourMatch.makeColor(0.6, 0.23, 0.11);
   private final Color ugly = coolourMatch.makeColor(0.36, 0.52, 0.11);

   private WPI_TalonSRX tal8;
   int loop = 0;


   /**
    * Creates a new Wheel.
    */
   public Wheel() {
     Sol5 = new DoubleSolenoid(11,1,5);
     tal8 = new WPI_TalonSRX(7);
   }
    public void up(){
     Sol5.set(DoubleSolenoid.Value.kReverse);
  }

  public void down(){
     Sol5.set(DoubleSolenoid.Value.kForward);
  }

  public void initFind(){
    coolourMatch.addColorMatch(blu);
    coolourMatch.addColorMatch(grass);
    coolourMatch.addColorMatch(ugly);
    coolourMatch.addColorMatch(bestCoolour);
  }

  public void stage2(){
    Color detect = coolour.getColor();
    ColorMatchResult result = coolourMatch.matchClosestColor(detect);

    tal8.set(1);

    if(result.color == blu){
      loop++;
    }

    if(loop == 7){
      tal8.set(0);
      SmartDashboard.putString("Is", "finished");
    }

  }

  public void stage3(){
    Color detect = coolour.getColor();
    ColorMatchResult result = coolourMatch.matchClosestColor(detect);
    String dat;
    dat = DriverStation.getInstance().getGameSpecificMessage();
    
    tal8.set(1);

    if(result.color == blu && dat.charAt(0) == 'R'){
      tal8.set(0);
    }else if(result.color == bestCoolour && dat.charAt(0) == 'B'){
      tal8.set(0);
    }else if(result.color == ugly && dat.charAt(0) == 'G'){
      tal8.set(0);
    }else if(result.color == grass && dat.charAt(0) == 'Y'){
      tal8.set(0);
    }

  }

  public void kill(){
    tal8.set(0);
  }

   @Override
   public void periodic() {
     // This method will be called once per scheduler run
   }
 }
