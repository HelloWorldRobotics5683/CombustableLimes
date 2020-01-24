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
  
  public static VictorSP SpinSpin = new VictorSP(RobotMap.RED775);
  public static VictorSP SpinTwin = new VictorSP(RobotMap.REDMOTOR2);

  public static SpeedControllerGroup SCG;
// TODO: if is already inverted, then fix
  public SpinnyBoi() {
  SpinTwin.setInverted(true);
  SCG = new SpeedControllerGroup(SpinSpin, SpinTwin);
  }

  public void SpinsTheSpinSpin(double speed) {
    SCG.set(speed);

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
