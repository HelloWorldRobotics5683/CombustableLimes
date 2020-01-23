/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class FruitRollUp extends SubsystemBase {
  
  /**
   * Creates a new FruitRollUp.
   */
  public static WPI_TalonSRX FL = new WPI_TalonSRX(RobotMap.FL);
  public static WPI_TalonSRX FR = new WPI_TalonSRX(RobotMap.FR);
  public static WPI_TalonSRX RL = new WPI_TalonSRX(RobotMap.RL);
  public static WPI_TalonSRX RR = new WPI_TalonSRX(RobotMap.RR);

  public FruitRollUp(){

  }

  public static MecanumDrive MD = new MecanumDrive(FL, RL, FR, RR);
  
  public void DriveMecanumGeneric(double x, double y, double z){
    MD.setRightSideInverted(true);
    MD.driveCartesian(x, y, z);
  }
  

  public void feed() {
    MD.feedWatchdog();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setDefaultCommand(Object driveMecanumGeneric) {
    

  }
}
