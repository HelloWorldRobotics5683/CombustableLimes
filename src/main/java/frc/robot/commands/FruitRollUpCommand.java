/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import frc.robot.RobotContainer;
import java.util.function.DoubleSupplier;
public class FruitRollUpCommand extends CommandBase {
private final FruitRollUp fru;
DoubleSupplier xVal;
DoubleSupplier yVal;
DoubleSupplier zVal;
  
  
  //private final RobotContainer m_oi = new RobotContainer();  


  public FruitRollUpCommand(FruitRollUp subsystem, DoubleSupplier x, DoubleSupplier y, DoubleSupplier z) {
    xVal = x;
    yVal = y;
    zVal = z;
    fru = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    fru.feed();
    // TODO: Check the directions of these values
    fru.DriveMecanumGeneric(xVal.getAsDouble(), yVal.getAsDouble(), zVal.getAsDouble());
    
    
  
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
