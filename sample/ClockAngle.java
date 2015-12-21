package sample;

/*
 * Find the angle between the minute and the hours hand of a clock
 * Author : Aamin Lakhani
 * 
 */
public class ClockAngle {

	public static double calculateAngle(int hours, int mins) {
		
		if(hours < 0.0 || hours > 12.0 || mins < 0.0 || mins > 60) {
			System.out.println("Invalid input");
			return -1.0;
		}
		
		double hours_angle = 0.5 * ((hours * 60.0) + mins);
		double mins_angle = 6 * mins;
		
		double difference = Math.abs(hours_angle  - mins_angle);
		difference = Math.min(difference, 360.0 - difference);
		
		return difference;
	}
	public static void main (String args[])  {
		
		System.out.println(calculateAngle(3, 45));
	}
}
