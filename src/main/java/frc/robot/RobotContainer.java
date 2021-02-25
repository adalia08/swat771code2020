/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//controller stuff
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//commands + subsystems
import frc.robot.commands.*;
import frc.robot.subsystems.*;

//set up
import edu.wpi.first.wpilibj2.command.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands(not defult commands... see below) are defined here:
   private Drive drive = new Drive();
   private ExampleSubsystem ExampleSubsystem  = new ExampleSubsystem();
   private ExampleCommand m_autoCommand = new ExampleCommand(ExampleSubsystem);
   private Intake intake = new Intake();
   private Conveyor conveyor = new Conveyor();
   private Door door = new Door();
   private Wheel wheel = new Wheel();


  //name your button variables and set up your joysticks

  public Joystick driverjoystick = new Joystick(0);
  public Joystick oJoystick = new Joystick(1);

    public JoystickButton A1 =  new JoystickButton(oJoystick, 1);
    public JoystickButton B1 =  new JoystickButton(oJoystick, 2);
    public JoystickButton X1 =  new JoystickButton(oJoystick, 3);
    public JoystickButton Y1 =  new JoystickButton(oJoystick, 4);
    public JoystickButton TL =  new JoystickButton(oJoystick, 5);
    public JoystickButton TR =  new JoystickButton(oJoystick, 6);
    public JoystickButton LB =  new JoystickButton(oJoystick, 7);
    public JoystickButton RB =  new JoystickButton(oJoystick, 8);
    public JoystickButton back = new JoystickButton(oJoystick, 7);
    public JoystickButton start = new JoystickButton(oJoystick, 8);
    public JoystickButton Stick1 = new JoystickButton(oJoystick, 9);
    public JoystickButton Stick2 = new JoystickButton(oJoystick, 10);

    public JoystickButton LB2 = new JoystickButton(oJoystick, 7);
    public JoystickButton RB2 = new JoystickButton(oJoystick, 8);
   /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //.set defult commands:
    drive.setDefaultCommand(new DriveCommand(drive, () ->  driverjoystick.getRawAxis(1), () -> driverjoystick.getRawAxis(4))); //() -> means double sender, will constantly send info instead of once
    intake.setDefaultCommand(new IntakeKill(intake)); 
    conveyor.setDefaultCommand(new ConveyorKill(conveyor));
    wheel.setDefaultCommand(new wheelKill(wheel));
 //   door.setDefaultCommand(new CloseDoor(door));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      //set the buttons and what they do
// Operator
    Stick1.whileHeld(new WheelDown(wheel));
    Stick2.whileHeld(new WheelUp(wheel));
    A1.whileHeld(new stage2(wheel));
    B1.whileHeld(new stage3(wheel));
    X1.whileHeld(new BallsIn(conveyor, intake));
    Y1.whileHeld(new outballs(intake, conveyor));
    start.whileHeld(new IntakeRaise(intake));
    back.whileHeld(new IntakeLower(intake));
    TR.whileHeld(new OpenDoor(door));
    TL.whileHeld(new CloseDoor(door));


    // a button for conveyor outake 

// Driver
    // TL = new JoystickButton(driverjoystick, 5);
    // TL.whileHeld(new DriveSlow(drive));
    
    // TR = new JoystickButton(driverjoystick, 6);
    // TR.whileHeld(new QuickTurn(drive));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
