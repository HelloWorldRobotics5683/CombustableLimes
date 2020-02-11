/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.VictorSP;



public class FruitPickerSubsystem extends SubsystemBase {
  /**
   * Creates a new FruitPickerSubsystem.
   */
  public static VictorSP fruYeet = new VictorSP(RobotMap.FRUPICK);
  public FruitPickerSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void consume(double power){
    fruYeet.set(power);
  }

}
