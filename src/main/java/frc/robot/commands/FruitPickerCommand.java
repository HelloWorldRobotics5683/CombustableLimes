/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.FruitPickerSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class FruitPickerCommand extends CommandBase {
  /**
   * Creates a new FruitPickerCommand.
   */

  boolean finished;
  FruitPickerSubsystem fpSubsystem;
  public FruitPickerCommand(FruitPickerSubsystem subsystem, boolean yeet) {
    fpSubsystem = subsystem;
    finished = yeet;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    fpSubsystem.consume(0.8);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    fpSubsystem.consume(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
