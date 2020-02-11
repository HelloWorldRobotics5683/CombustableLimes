/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.subsystems.*;

public class ColorWheelRotationCommand extends CommandBase {
  ColorSensorSubsystem cs;
  int count;
  Color initial;
  /**
   * Creates a new ColorWheelRotation.
   */
  public ColorWheelRotationCommand(ColorSensorSubsystem subsystem) {
    cs = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    count = 1;
    initial = cs.currentColor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    count = cs.colorCounter(initial, count);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(count < 24) {
      return false;
    } else {
      return true;
    }
  }
}
