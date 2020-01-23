/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.SpinnyBoi;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinnyBoiCommand extends CommandBase {
  /**
   * Creates a new SpinnyBoiCommand.
   */
  private final SpinnyBoi SB;
  double yeeter;
  
  public SpinnyBoiCommand(SpinnyBoi subsystem, double yeet) {
    yeeter = yeet;
    SB = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SB.SpinsTheSpinSpin(yeeter);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
