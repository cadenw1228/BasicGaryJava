// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  Spark rightSpark = new Spark(0);
  Spark leftSpark = new Spark(1);
  Spark shooter = new Spark(2);
  Spark aim = new Spark(3);
  Joystick joystick = new Joystick(0);
  Servo servo = new Servo(7);
    
  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    System.out.print("test");
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    rightSpark.set(joystick.getRawAxis(5) * 0.5);
    leftSpark.set(joystick.getRawAxis(1) * -0.5);
    shooter.set(joystick.getRawAxis(3) * -0.5);
    if(joystick.getPOV() == 0){
      aim.set(0.5);
    }else if(joystick.getPOV() == 180){
      aim.set(-0.5);
    }else{
      aim.set(0);
    }
    if(joystick.getRawButton(1)){
      servo.setAngle(120);
    }else{
      servo.setAngle(180);
    }
    
  }
}
