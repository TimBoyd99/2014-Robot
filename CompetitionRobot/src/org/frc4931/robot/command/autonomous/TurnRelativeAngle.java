package org.frc4931.robot.command.autonomous;

import org.frc4931.robot.Subsystems;
import org.frc4931.robot.command.drive.PIDTurnInterface;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class TurnRelativeAngle extends Command{
	private final PIDController pid;
	private final double targetAngle;
	public TurnRelativeAngle(double angle) {
		requires(Subsystems.driveTrain);
		requires(Subsystems.imu);
		targetAngle = Subsystems.imu.getAngle()+angle;
		pid = new PIDController(1,0,0,Subsystems.imu.getGyro(),new PIDTurnInterface());
		pid.setOutputRange(-0.75, 0.75);
		pid.setInputRange(0, 360);
		pid.setContinuous();
	}

	protected void end() {
		Subsystems.driveTrain.stop();
	}

	protected void execute() {
	}

	protected void initialize() {
		pid.setSetpoint(targetAngle);
		pid.enable();
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return pid.onTarget();
	}

}