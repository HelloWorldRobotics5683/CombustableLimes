/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.I2C;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class ColorSensorSubsystem extends SubsystemBase {
  /**
   * Creates a new ColorSensorSubsystem.
   */
  
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
   
  private final ColorMatch m_colorMatcher = new ColorMatch();

  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  private final WPI_VictorSPX ColorWheel = new WPI_VictorSPX(RobotMap.COLORWHEEL);
  int wheelCount;
  Color initColor;
  Color nextColor;

  public ColorSensorSubsystem() {

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);   
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public Color currentColor() {
    Color detectedColor = m_colorSensor.getColor();
    ColorMatchResult currentColor = m_colorMatcher.matchClosestColor(detectedColor);
    return currentColor.color;
  }

  public String colorToString(Color currentColor) {
    Color color = currentColor;
    if (color == kBlueTarget) {
      return "Blue";
    } else if (color == kRedTarget) {
      return "Red";
    } else if (color == kGreenTarget) {
      return  "Green";
    } else if (color == kYellowTarget) {
      return "Yellow";
    } else {
      return "Unknown";
    }
  }

  public int colorCounter(Color initialColor, int count) {
    initColor = initialColor;
    wheelCount = count;
    ColorWheel.set(.25);
    nextColor = currentColor();
    if(initColor != nextColor) {
       wheelCount++;
       initColor = nextColor;
    }
    if (wheelCount > 24) {
      ColorWheel.set(0.0);
    }
    return wheelCount;
  }
  
}
