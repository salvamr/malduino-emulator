package emulator;

import java.awt.event.KeyEvent;
import interpreter.CommandInterpreter;

public enum Commands {
	DELAY {

		@Override
		public void execute(CommandInterpreter cmd) {
			try {
				Thread.sleep(cmd.intValue());
			} catch (Exception ex) {
				new Error(ex.getMessage());
			}
		}

	},
	STRING {

		@Override
		public void execute(CommandInterpreter cmd) {
			for (char c : cmd.stringValue().toCharArray()) {
				this.keyboard.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
			}
		}

	},
	WINDOWS {

		@Override
		public void execute(CommandInterpreter cmd) {
			if (cmd.hasTwoElements()) {
				this.keyboard.keyPressCombo(KeyEvent.VK_WINDOWS, cmd.intValue());
			} else {
				this.keyboard.keyPress(KeyEvent.VK_WINDOWS);
			}
		}

	},
	MENU {

		@Override
		public void execute(CommandInterpreter cmd) {
			this.keyboard.keyPress(KeyEvent.VK_CONTEXT_MENU);
		}

	},
	SHIFT {

		@Override
		public void execute(CommandInterpreter cmd) {
			if (cmd.hasThreeElements()) {
				this.keyboard.keyPressCombo(
						KeyEvent.VK_SHIFT, 
						cmd.stringToKeyEvent(cmd.secondCommand()), 
						cmd.stringToKeyEvent(cmd.thirdCommand()));
			} else {
				this.keyboard.keyPressCombo(
						KeyEvent.VK_SHIFT, 
						cmd.stringToKeyEvent(cmd.secondCommand()));
			}
		}

	},
	ALT {

		@Override
		public void execute(CommandInterpreter cmd) {

		}

	},
	CONTROL {

		@Override
		public void execute(CommandInterpreter cmd) {

		}

	},
	DOWNARROW {

		@Override
		public void execute(CommandInterpreter cmd) {

		}

	},
	LEFTARROW {

		@Override
		public void execute(CommandInterpreter cmd) {

		}

	},
	RIGHTARROW {

		@Override
		public void execute(CommandInterpreter cmd) {

		}

	},
	UPARROW {

		@Override
		public void execute(CommandInterpreter cmd) {

		}

	}, 
	REPEAT {
		
		@Override
		public void execute(CommandInterpreter cmd) {
			
		}
		
	};

	protected Keyboard keyboard = new Keyboard();
	
	public abstract void execute(CommandInterpreter cmd);
}
