package pack;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;

public class Pihdit extends Thread {
	private EV3IRSensor infraredSensor;
	private RegulatedMotor pihti;

	public Pihdit(EV3IRSensor sensor, RegulatedMotor pihti) {
		this.infraredSensor = sensor;
		this.pihti = pihti;

	}

	public void run() {

		while (!Button.ESCAPE.isDown()) {
			// keyPressed(Key k) {

			// toimintoja ja mitä nappeja ollaan painettu
			int remoteCommand = infraredSensor.getRemoteCommand(0);
			if (remoteCommand == 4) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				pihditstop();

			} else if (remoteCommand == 8) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				pihditauki();

			} else if (remoteCommand == 6) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				pihditkiinni();

				LCD.clear();

			}
		}

	}

	public void pihditstop() {
		this.pihti.stop();

	}

	public void pihditauki() {
		pihti.forward();

	}

	public void pihditkiinni() {
		pihti.backward();
	}
}
