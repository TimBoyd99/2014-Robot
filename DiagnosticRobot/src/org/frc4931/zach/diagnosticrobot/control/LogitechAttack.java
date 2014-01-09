package org.frc4931.zach.diagnosticrobot.control;


public class LogitechAttack extends FlightStick{
	/*Axes Definitions*/
	public static final int PITCH_AXIS = 2;
	public static final int ROLL_AXIS = 1;
	public static final int YAW_AXIS = 3;
	public static final int THROTTLE_AXIS = 4;
	
	/*Button Definitions*/
	//TODO Define Buttons
	
	public LogitechAttack(int port) {
		super(port, "Logitech Attack 3");
	}

	//TODO Tune methods to return correct values.
	//@Override
	public double getPitch() {
		return getAxis(PITCH_AXIS);
	}

	//@Override
	public double getNormalPitch() {
		return getNormalizedAxis(PITCH_AXIS);
	}

	//@Override
	public double getYaw() {
		return getAxis(YAW_AXIS)*-1;
	}

	//@Override
	public double getNormalYaw() {
		return getNormalizedAxis(YAW_AXIS);
	}

	//@Override
	public double getRoll() {
		return getAxis(ROLL_AXIS);
	}

	//@Override
	public double getNormalRoll() {
		return getNormalizedAxis(ROLL_AXIS);
	}

	//@Override
	public double getThrottle() {
		return getAxis(THROTTLE_AXIS);
	}

	//@Override
	public double getNormalThrottle() {
		return 1-getNormalizedAxis(THROTTLE_AXIS);
	}

	//@Override
	protected void putDashboard() {
		table.putNumber("Channel", port);
		table.putNumber("Pitch Axis", getPitch());
		table.putNumber("Roll Axis", getRoll());
		table.putNumber("Yaw Axis", getYaw());
		table.putNumber("Throttle Axis", getThrottle());
	}
}