/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretRotateCommand extends CommandBase {
  /**
   * Creates a new TurretRotateCommand.
   */
  LimesSubsystem lsSubs;
  TurretRotateSubsystem TRS;
  boolean donezo;
  double target;
  double error;
  
  

  public TurretRotateCommand(LimesSubsystem lsSubsystem, TurretRotateSubsystem turRotSub, double errorRange) {
    lsSubs = lsSubsystem;
    TRS = turRotSub;
    error = errorRange;

    addRequirements(TRS, lsSubs);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    donezo = false;
    target = TRS.setTarget(lsSubs.getXDisplacement(), lsSubs.getDistance());
    
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    donezo = TRS.rotate(target, error);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    TRS.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return donezo;
  }
}
