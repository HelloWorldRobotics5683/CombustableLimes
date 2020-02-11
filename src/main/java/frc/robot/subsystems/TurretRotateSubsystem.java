/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

public class TurretRotateSubsystem extends SubsystemBase {
  public static WPI_TalonSRX TURRETROTATE = new WPI_TalonSRX(RobotMap.ROTATION);
  /**
   * Creates a new TurretRotateSubsystem.
   */
  public static final int kSlotIdx = 0;
  public static final int kPIDLoopIdx = 0;
  public static final int kTimeoutMs = 15;
  public final double kP = 1;
  public final double kI = 0.0125;
  public final double kD = 9;
  public final double kF = 0.1364;
  public final int kIzone = 75;
  public final double kPeakOutput = 0.001;
  public boolean done;
  public int startPosition;
  public static boolean kSensorPhase = false;
  public static boolean kMotorInvert = false;

  public TurretRotateSubsystem() {
    TURRETROTATE.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    TURRETROTATE.setNeutralMode(NeutralMode.Brake);
    TURRETROTATE.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx, kTimeoutMs);
		TURRETROTATE.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, kTimeoutMs);
		TURRETROTATE.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, kTimeoutMs);
		TURRETROTATE.setSensorPhase(kSensorPhase); 
		TURRETROTATE.setInverted(kMotorInvert);
		TURRETROTATE.configNominalOutputForward(0, kTimeoutMs);
		TURRETROTATE.configNominalOutputReverse(0, kTimeoutMs);
		TURRETROTATE.configPeakOutputForward(1, kTimeoutMs);
		TURRETROTATE.configPeakOutputReverse(-1, kTimeoutMs);
		TURRETROTATE.configAllowableClosedloopError(kPIDLoopIdx, 0, kTimeoutMs);
		TURRETROTATE.config_kF(kPIDLoopIdx, kF, kTimeoutMs);
		TURRETROTATE.config_kP(kPIDLoopIdx, kP, kTimeoutMs);
		TURRETROTATE.config_kI(kPIDLoopIdx, kI, kTimeoutMs);
   	TURRETROTATE.config_kD(kPIDLoopIdx, kD, kTimeoutMs);
    TURRETROTATE.configMotionCruiseVelocity(750, kTimeoutMs);// Vel original 600
		TURRETROTATE.configMotionAcceleration(1000, kTimeoutMs);
		TURRETROTATE.setSelectedSensorPosition(0, kPIDLoopIdx, kTimeoutMs);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  //Gets the current position of the motor in raw sensor units
  public int getPos() {
    startPosition = TURRETROTATE.getSelectedSensorPosition(0);
    return startPosition;
  }
  //takes x displacement from limelight, multiplies it by ticks per angle, and returns predicted num of ticks
  public double setTarget(double x, double distance){
    return (x - 3) * RobotMap.TICKS_DEGREES + getPos();
  }
  //Takes the target position in ticks, and the degrees of error based off of our limelight.
  public boolean rotate(double targetInTicks, double error){
    double targetPosition = targetInTicks;
    double errorInTicks = error * RobotMap.TICKS_DEGREES;
//First condition is lower range and second condition is higher range
    if (getPos() > targetPosition + errorInTicks && getPos() <  targetPosition - errorInTicks) {
      TURRETROTATE.set(0.0);
      done = true;
      return done;
    } else {
      done = false;    
      TURRETROTATE.set(ControlMode.MotionMagic, targetPosition);
      return done;
    }
  }
//Sets motor output to zero once called
  public void stopMotor(){
    TURRETROTATE.set(0);
  }
  //Allows us to set power to the motors
  public void setPower(double throttle){
    TURRETROTATE.set(throttle);
  }
}
