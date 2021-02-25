//  /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

 package frc.robot.subsystems;

 import edu.wpi.first.wpilibj2.command.SubsystemBase;
 import com.ctre.phoenix.motorcontrol.can.*;
 import edu.wpi.first.wpilibj.DoubleSolenoid;

 public class Intake extends SubsystemBase {
     private WPI_TalonSRX talonSRX7 ;
     private DoubleSolenoid Sol1;
     private DoubleSolenoid Sol2;
     
     public Intake() { 
         talonSRX7 = new WPI_TalonSRX(10);
         Sol1 = new DoubleSolenoid(11,0,4); 
         Sol2 = new DoubleSolenoid(11,3,7); //
         // 0,4 DOOR
         //1,5 INTAKE
         //2,6 INTAKE
         //3,7 WHEEL
     }
     
     public void raise(){
         Sol1.set(DoubleSolenoid.Value.kReverse);
         Sol2.set(DoubleSolenoid.Value.kReverse);
         //Sol1.set(DoubleSoleno);
     }
     
     public void lower(){
         Sol1.set(DoubleSolenoid.Value.kForward);
         Sol2.set(DoubleSolenoid.Value.kForward);
     }

     public void on(double speed){
         talonSRX7.set(speed);
     }
     
     public void kill() {
         talonSRX7.set(0);
     }

     public void run(double speed){
        talonSRX7.set(speed);
     }
     
     @Override
     public void periodic() {

     }
  
 }