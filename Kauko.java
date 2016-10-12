package pack;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;


public class Kauko extends Thread {
	private RegulatedMotor rmotor;
	private RegulatedMotor lmotor;
	private EV3IRSensor infraredSensor;
private ColorReader vari;
	public Kauko(EV3IRSensor sensor, RegulatedMotor rmotor, RegulatedMotor lmotor) {
		this.infraredSensor = sensor;
		this.rmotor = rmotor;
		this.lmotor = lmotor;
		this.vari = new ColorReader();
	}

	// this is run when the thread is started
	public void run() {
vari.start();
		// escape the program
		while (!Button.ESCAPE.isDown()) {
			// keyPressed(Key k) {
			// sammutus
			if (Button.ENTER.isDown()) {
				System.exit(0);
			}
			// toimintoja ja mitä nappeja ollaan painettu
			int remoteCommand = infraredSensor.getRemoteCommand(0);
			if (remoteCommand == 0) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				stopmotorR();
				stopmotorL();
				
			} else if (remoteCommand == 2) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				forwardmotor();
				
			} else if (remoteCommand == 9) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				backwardmotor();
				
				LCD.clear();
			} else if (remoteCommand == 3) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				turnrightmotor();
				
				LCD.clear();
			} else if (remoteCommand == 1) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				turnleftmotor();
				
				LCD.clear();

				
			}

		}

	}
	
	public void stopmotorR() {
		this.rmotor.stop();
		
		
	}
	public void stopmotorL() {
		this.lmotor.stop();
		
		
	}

	/**
	 * eteen
	 */
	public void forwardmotor() {
		this.rmotor.forward();
		this.lmotor.forward();
		rmotor.setSpeed(vari.palauttaja());
		lmotor.setSpeed(vari.palauttaja());
	}

	/**
	 * taakse
	 */
	public void backwardmotor() {
		this.rmotor.backward();
		this.lmotor.backward();
		rmotor.setSpeed(vari.palauttaja());
		lmotor.setSpeed(vari.palauttaja());
	}

	/**
	 * oikealle
	 */
	public void turnrightmotor() {
		this.rmotor.forward();
		this.lmotor.backward();
		rmotor.setSpeed(vari.palauttaja());
		lmotor.setSpeed(vari.palauttaja());
	}

	/**
	 * vasemmalle
	 */
	public void turnleftmotor() {
		this.rmotor.backward();
		this.lmotor.forward();
		rmotor.setSpeed(vari.palauttaja());
		lmotor.setSpeed(vari.palauttaja());
	}


}
