/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimesSubsystem extends SubsystemBase {
  //Sets up the NetworkTables for us to pass inputs into
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");
  
  //read values periodically
   double x = tx.getDouble(0.0);
   double y = ty.getDouble(0.0);
   double area = ta.getDouble(0.0);
  public LimesSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public double getXDisplacement(){
    return tx.getDouble(0);
  }
  public double getArea(){
    return ta.getDouble(0);
  }
  public double getYdisplacement(){
    return ty.getDouble(0);
  }
  //since trigonometric functions in java return radians, to do proper calculations, convert degrees to radians
  public double getDistance(){
    double distance = (98.0-31.0) / (Math.tan(Math.toRadians(24.4 + getYdisplacement())));
    return distance;
  }
 
}
