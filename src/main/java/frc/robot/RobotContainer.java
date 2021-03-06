/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 
  

  private final AppleMapsSubsystem amc = new AppleMapsSubsystem();
  private final AppleMapsCommand amcCommand = new AppleMapsCommand(amc);

  private final LimesSubsystem ls = new LimesSubsystem();
  private final LimesCommand lsCommand = new LimesCommand(ls);

  //private final FruitRollUp fru = new FruitRollUp();

  private final TurretRotateSubsystem turRot = new TurretRotateSubsystem();

  private final SpinnyBoi SB = new SpinnyBoi();

  private final ColorSensorSubsystem cs = new ColorSensorSubsystem();
  private final ColorSensorCommand csCommand = new ColorSensorCommand(cs);
  private final ColorWheelRotationCommand rotationCommand = new ColorWheelRotationCommand(cs);

  private final FruitPickerSubsystem fpSubsystem = new FruitPickerSubsystem();

  private final ConveyorSubsystem conSubsystem = new ConveyorSubsystem();
  private final ExampleSubsystem m_subsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_subsystem);
  
  
  
  Joystick joy = new Joystick(0);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //TODO: Play Congress.
    //fru.setDefaultCommand(new FruitRollUpCommand(fru, () -> joy.getX(), () -> joy.getY(), () -> joy.getZ()));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

   
   
 
   private void configureButtonBindings() {
    JoystickButton b1 = new JoystickButton(joy, 1);
    JoystickButton b2 = new JoystickButton(joy, 2);
    JoystickButton b3 = new JoystickButton(joy, 3);
    JoystickButton b4 = new JoystickButton(joy, 4);
    JoystickButton b5 = new JoystickButton(joy, 5);
    JoystickButton b6 = new JoystickButton(joy, 6);
    JoystickButton b7 = new JoystickButton(joy, 7);
    JoystickButton b8 = new JoystickButton(joy, 8);
    JoystickButton b9 = new JoystickButton(joy, 9);
    JoystickButton b10 = new JoystickButton(joy, 10);
    JoystickButton b11 = new JoystickButton(joy, 11);
    JoystickButton b12 = new JoystickButton(joy, 12);

    b1.whileHeld(new SpinnyBoiCommand(SB, ((1 + joy.getThrottle()) / 2.0))).whenInactive(new SpinnyBoiCommand(SB, 0.0));
    b2.whenPressed(amcCommand);
    b3.whenPressed(new TurretRotateManualCommand(turRot, -.2)).whenReleased(new TurretRotateManualCommand(turRot, 0));
    b4.whileHeld(new TurretRotateManualCommand(turRot, .2)).whenReleased(new TurretRotateManualCommand(turRot, 0));
    b5.whenPressed(lsCommand);
    //b6.whileHeld(new TurretRotateCommand(ls, turRot, .5)).whenReleased(new TurretRotateCommand(ls, turRot, .25));
    //b6.whenPressed(new SequentialCommandGroup(new TurretRotateCommand(ls, turRot, .5), new TurretRotateCommand(ls, turRot, .25)));
    b6.whenPressed(new TurretRotateCommand(ls, turRot, .25));
    // Testing buttons for turret power levels
    
    b7.whileHeld(new FruitPickerCommand(fpSubsystem, false)).whenInactive(new FruitPickerCommand(fpSubsystem, true));
    b8.whileHeld(new SpinnyBoiCommand(SB, 0.60)).whenInactive(new SpinnyBoiCommand(SB, 0.0));
    b9.whileHeld(new SpinnyBoiCommand(SB, 0.70)).whenInactive(new SpinnyBoiCommand(SB, 0.0));
    b10.whileHeld(new SpinnyBoiCommand(SB, 0.80)).whenInactive(new SpinnyBoiCommand(SB, 0.0));
    //Elijah's Bonus Testing Buttons
    b11.whileHeld(new SpinnyBoiCommand(SB, 0.90)).whenInactive(new SpinnyBoiCommand(SB, 0.0));
    b12.whileHeld(new SpinnyBoiCommand(SB, 1.0)).whenInactive(new SpinnyBoiCommand(SB, 0.0));
  }

  public Double driveX(){
    return joy.getX();
  }
  public Double driveY(){
    return joy.getY();
  }
  public Double twistZ(){
    return joy.getZ();
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
