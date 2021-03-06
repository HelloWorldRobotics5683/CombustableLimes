/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.commands;

import frc.robot.subsystems.ConveyorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ConveyorCommand extends CommandBase {
  /**
   * Creates a new ConveyorCommand.
   */
  private final ConveyorSubsystem conSub;
  double power;

  public ConveyorCommand(ConveyorSubsystem subsystem, double throttle) {
    conSub = subsystem;
    power = throttle;
    addRequirements(conSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conSub.intakeSpin(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
