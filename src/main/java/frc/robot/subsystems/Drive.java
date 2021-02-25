/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;

public class Drive extends SubsystemBase {
 
  private WPI_TalonSRX talonSRX1;
  private WPI_TalonSRX talonSRX2;
  private WPI_TalonSRX talonSRX3;
  private SpeedControllerGroup speedControllerGroup1;
  private WPI_TalonSRX talonSRX4;
  private WPI_TalonSRX talonSRX5;
  private WPI_TalonSRX talonSRX6;
  private SpeedControllerGroup speedControllerGroup2;
  private DifferentialDrive differentialDrive1;
  double x;
  double y;
  public static boolean quicky = false;
  public ADXRS450_Gyro gyro; 
  public AnalogInput anin;
  //public AnalogGyro hello = new AnalogGyro(1);
  //public boolean gyroDominance;
  
 

  
  /**
   * Creates a new Drive.
   */
  public Drive() {
    talonSRX1= new WPI_TalonSRX(1);
    talonSRX2= new WPI_TalonSRX(2);
    talonSRX3= new WPI_TalonSRX(3);


    speedControllerGroup1 = new SpeedControllerGroup(talonSRX1,talonSRX2,talonSRX3);
    
    talonSRX4= new WPI_TalonSRX(4);
    talonSRX5= new WPI_TalonSRX(5);
    talonSRX6= new WPI_TalonSRX(6);

    speedControllerGroup2 = new SpeedControllerGroup(talonSRX4,talonSRX5,talonSRX6);

    differentialDrive1 = new DifferentialDrive(speedControllerGroup1, speedControllerGroup2);

    differentialDrive1.setSafetyEnabled(true);
    differentialDrive1.setExpiration(0.1);

    talonSRX1.configFactoryDefault();
    talonSRX2.configFactoryDefault();
    talonSRX3.configFactoryDefault();
    talonSRX4.configFactoryDefault();
    talonSRX5.configFactoryDefault();
    talonSRX6.configFactoryDefault();
    //gyroDominance = false;
    gyro = new ADXRS450_Gyro();
    anin = new AnalogInput(1);

  }

  public double deadband(double input){
    if(input < 0.05 && input > -0.05){
      return 0;
    }else{
      return input;
    }
  }

  public void Drivecode(double x, double y){
    double dx = deadband(x);
    differentialDrive1.curvatureDrive(Math.pow(Math.sin(((Math.abs(dx))*Math.PI)), 2)*Math.signum(dx), y/1.2, quicky);
  }

  public void setMaxOutput(double var){
    differentialDrive1.setMaxOutput(var);
  }

  public void setQuick(boolean quack){
    quicky = quack;
  } 

  public void encoinit(){
    talonSRX1.follow(talonSRX3);
    talonSRX2.follow(talonSRX3);
    talonSRX5.follow(talonSRX4);
    talonSRX6.follow(talonSRX4);
  }

  public boolean wheelmove(){
   double enc1 =  talonSRX3.getSelectedSensorVelocity();
   double enc2 = talonSRX4.getSelectedSensorVelocity();
    if ((enc1 < 1 && enc1 > -1) && (enc2 < 1 && enc2 > -1 )){
      return false;
    }else{
      return true;
    }
  }

  public void gyroinit(){
    gyro.reset();
  }

  public double Limiter(double input, double limit){
    if(input > limit){
      return limit;
    }else if (input < -limit){
      return limit;
    }else{
      return input;
    }
  }

  

  public double gyroAngle(){
    double angle = gyro.getAngle();
    double kp = -1.5;

    if (angle > -12 && angle < 12){
      if (angle > -8.5 && angle < 8.5){
        kp = -2.7;
      }else{
        kp = -2.3;
      }
    }

    double rate = Limiter(angle/100*kp, 1);
    return rate;    
  }
  @Override
  public void periodic() {
  } 
 
    // This method will be called once per scheduler run
  
}
