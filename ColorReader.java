
package pack;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.*;
import lejos.robotics.Color;
 
public class ColorReader extends Thread {
	private int nopeus;
	EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S2);
public ColorReader() {
	nopeus = 700;
}
public int palauttaja() {
	return this.nopeus;
}
    public void run() {
        boolean kaikkiOK = true;
 
        while (kaikkiOK) {
 
            
            while (!Button.ESCAPE.isDown()) {
                LCD.clear();
                switch (cs.getColorID()) {
 
                case Color.RED:
                    LCD.drawString("SÄRKYVÄÄ!", 0, 2);
                    LCD.drawString("Nopeus rajoitettu", 0, 3);
                    Button.LEDPattern(2);
                   nopeus = 350;
                    break;
 
                case Color.GREEN:
                    LCD.drawString("Purkualue", 0, 2);
                    LCD.drawString("Ei Rajoituksia", 0, 3);
                    Button.LEDPattern(1);
                   nopeus = 700;
                   break;

                   
                }
 
            }
        }
    }
}