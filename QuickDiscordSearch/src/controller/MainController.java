package controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import model.Save;

public class MainController {
	
	private Save save = new Save();
	private Robot robot = new Robot();
	
	public void SetSave(Save save) {
		this.save = save;
	}
	
	public Save GetSave() {
		return this.save;
	}
	
	public MainController() throws AWTException {
		robot.setAutoDelay(40);
	    robot.setAutoWaitForIdle(true);
	    
	    System.out.println("Macro actions");
	    
	    // In order to search, Left Click x3, Right Click x1, Key down x2 and Key enter needs to be done
	    LeftClick();
	    LeftClick();
	    LeftClick();
	    RightClick();
	    KeyInput(40); // 40 is key down
	    KeyInput(40);
	    KeyInput(10); // 10 is key enter
	}

	private void LeftClick() {
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    robot.delay(50);
	    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	    robot.delay(50);
	}
	
	private void RightClick() {
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
	    robot.delay(50);
	    robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	    robot.delay(50);
	}
	
	private void KeyInput(int key) {
		robot.delay(40);
	    robot.keyPress(key);
	    robot.keyRelease(key);
	}
	
	
}
