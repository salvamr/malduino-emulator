package emulator;

import java.awt.AWTException;
import java.awt.Robot;

public class Keyboard {
	private Robot kb;

	public Keyboard() {
		try {
			kb = new Robot();
		} catch (AWTException e) {
			new Error(e.getMessage());
		}
	}

	public void keyPress(int key) {
		kb.keyPress(key);
		kb.keyRelease(key);
	}
	
	public void keyPressCombo(int modifier, int key) {
		kb.keyPress(modifier);
		kb.keyPress(key);
		
		kb.keyRelease(modifier);
		kb.keyRelease(key);
	}
	
	public void keyPressCombo(int modifier1, int modifier2, int key) {
		kb.keyPress(modifier1);
		kb.keyPress(modifier2);
		kb.keyPress(key);
		
		kb.keyRelease(modifier1);
		kb.keyPress(modifier2);
		kb.keyRelease(key);
	}
}
