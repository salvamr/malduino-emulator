package interpreter;

import java.awt.event.KeyEvent;

public class CommandInterpreter {

	private String[] commandElement;

	public CommandInterpreter(String line) {
		this.commandElement = line.split("\\s+");
	}

	public String name() {
		return this.commandElement[0];
	}

	public int stringToKeyEvent(String cmd) {
		switch (cmd) {
			case "DELETE":
				return KeyEvent.VK_DELETE;
			case "BREAK":
				return KeyEvent.VK_PAUSE;
			case "CAPSLOCK":
				return KeyEvent.VK_CAPS_LOCK;
			case "NUMLOCK":
				return KeyEvent.VK_NUM_LOCK;
			case "PRINTSCREEN":
				return KeyEvent.VK_PRINTSCREEN;
			case "SCROLLLOCK":
				return KeyEvent.VK_SCROLL_LOCK;
			case "HOME":
				return KeyEvent.VK_HOME;
			case "INSERT":
				return KeyEvent.VK_INSERT;
			case "PAGEUP":
				return KeyEvent.VK_PAGE_UP;
			case "PAGEDOWN":
				return KeyEvent.VK_PAGE_DOWN;
			case "UPARROW":
				return KeyEvent.VK_UP;
			case "DOWNARROW":
				return KeyEvent.VK_DOWN;
			case "LEFTARROW":
				return KeyEvent.VK_LEFT;
			case "RIGHTARROW":
				return KeyEvent.VK_RIGHT;
			case "TAB":
				return KeyEvent.VK_TAB;
			case "END":
				return KeyEvent.VK_END;
			case "ESC":
			case "ESCAPE":
				return KeyEvent.VK_ESCAPE;
			case "F1":
				return KeyEvent.VK_F1;
			case "F2":
				return KeyEvent.VK_F2;
			case "F3":
				return KeyEvent.VK_F4;
			case "F4":
				return KeyEvent.VK_F4;
			case "F5":
				return KeyEvent.VK_F5;
			case "F6":
				return KeyEvent.VK_F6;
			case "F7":
				return KeyEvent.VK_F7;
			case "F8":
				return KeyEvent.VK_F8;
			case "F9":
				return KeyEvent.VK_F9;
			case "F10":
				return KeyEvent.VK_F10;
			case "F11":
				return KeyEvent.VK_F11;
			case "F12":
				return KeyEvent.VK_F12;
			case "SPACE":
				return KeyEvent.VK_SPACE;
			default:
				return KeyEvent.getExtendedKeyCodeForChar(cmd.charAt(0));
		}
	}

	public boolean hasThreeElements() {
		return this.commandElement.length == 3 ? true : false;
	}

	public boolean hasTwoElements() {
		return this.commandElement.length == 2 ? true : false;
	}

	public boolean isSingleElement() {
		return this.commandElement.length == 1 ? true : false;
	}

	public String firstCommand() {
		return this.commandElement[0];
	}

	public String secondCommand() {
		return this.commandElement[1];
	}

	public String thirdCommand() {
		return this.commandElement[2];
	}

	public int intValue() {
		int val = 0;

		try {
			val = Integer.parseInt(this.commandElement[1]);
		} catch (Exception e) {
			new Error(e.getMessage());
		}

		return val;
	}

	public String stringValue() {
		String tempLine = "";

		for (int i = 1; i < this.commandElement.length; i++) {
			if (i == this.commandElement.length - 1) {
				tempLine += this.commandElement[i];
				break;
			}
			tempLine += this.commandElement[i] + " ";
		}

		return tempLine;
	}

}
