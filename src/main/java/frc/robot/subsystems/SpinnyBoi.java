/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class SpinnyBoi extends SubsystemBase {
  /**
   * Creates a new SpinnyBoi.
   */

  // hello world ~ Mason Wyman 2020

  // The motor controllers used for firing the turret
  public static VictorSP SpinSpin = new VictorSP(RobotMap.REDMOTOR1);
  public static VictorSP SpinTwin = new VictorSP(RobotMap.REDMOTOR2);
//Motor group created using both motors 
  public static SpeedControllerGroup SCG;

  public SpinnyBoi() {
  
  SCG = new SpeedControllerGroup(SpinSpin, SpinTwin);
  }

  public void TurretShooter(double speed) {
    SCG.set(-1 * speed); // turn the motors around maybe

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
