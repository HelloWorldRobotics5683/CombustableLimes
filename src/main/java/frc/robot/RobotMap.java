/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class RobotMap {
   
    // Drive Motors
    // Talon SRX motor controllers
    public static final int FL = 1;
    public static final int FR = 2;
    public static final int RL = 3;
    public static final int RR = 4;
    
    // Turret Motors
    // Talon SRX motor controllers
    public static final int ROTATION = 5;

    // VictorSP motor controllers
    public static final int REDMOTOR1 = 0;
    public static final int REDMOTOR2 = 1;
    public static final int FRUPICK = 2;
    public static final int CONVEYOR = 3;
    // Color Wheel motors
    // Victor SPX motor controller
    public static final int COLORWHEEL = 6;
    //Constants
    public static final double TICKS_DEGREES = 91.02;
}
