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

public class SpinnyBoi extends SubsystemBase {
  /**
   * Creates a new SpinnyBoi.
   */
  public static VictorSP SpinSpin = new VictorSP(RobotMap.RED775);

  public SpinnyBoi() {

  }

  public void SpinsTheSpinSpin(double speed) {
    SpinSpin.set(speed);
    System.out.println("Method is alive: " + SpinSpin.isAlive());
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
