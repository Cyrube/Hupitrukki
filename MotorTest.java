
package pack;

import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;

public class MotorTest {
	public static void main(String[] args) {

		// Sensorit ja moottorit
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S3);
		RegulatedMotor rmotor = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor lmotor = new EV3LargeRegulatedMotor(MotorPort.C);
		RegulatedMotor pihti = new EV3LargeRegulatedMotor(MotorPort.A);
		// Kauko-ohjain
		Kauko kauko = new Kauko(irSensor, rmotor, lmotor);
		Pihdit pihdit = new Pihdit(irSensor, pihti);
		// K‰ynnistet‰‰n s‰ie
		kauko.start();
		pihdit.start();
		

	}
}
