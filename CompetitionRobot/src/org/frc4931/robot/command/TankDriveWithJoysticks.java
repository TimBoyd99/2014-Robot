package org.frc4931.robot.command;

import org.frc4931.robot.OperatorInterface;
import org.frc4931.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

public class TankDriveWithJoysticks extends Command{

	public TankDriveWithJoysticks() {
		requires(Subsystems.driveTrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		double scaledRightSpeed = OperatorInterface.joysticks[0].getPitch()*OperatorInterface.joysticks[0].getNormalThrottle();
		double scaledLeftSpeed = OperatorInterface.joysticks[1].getPitch()*OperatorInterface.joysticks[0].getNormalThrottle();
		Subsystems.driveTrain.tankDrive(scaledLeftSpeed, scaledRightSpeed);
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
	
	

}
