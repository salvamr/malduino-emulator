package emulator;

import java.io.File;
import java.util.ArrayList;
import interpreter.CommandInterpreter;
import parser.ScriptReader;

public class Malduino {
	private File filePath;
	
	public Malduino() {}
	
	public Malduino(String filePath) {
		this.filePath = new File(filePath);
	}

	public void start() {
		ScriptReader reader = new ScriptReader(this.filePath);
		ArrayList<String> script = reader.parse();
		
		for ( int i = 0; i < script.size(); i++) {
			String line = script.get(i);
			CommandInterpreter interpreter = new CommandInterpreter(line);
			
			if (interpreter.name().equals("REPEAT")) {
				for (int x = 0; x < interpreter.intValue(); x++) {
					String tempLine = script.get(i-1);
					CommandInterpreter tempInterpreter = new CommandInterpreter(tempLine);
					Commands.valueOf(tempInterpreter.name()).execute(tempInterpreter);
				}
				i++;
			}
			Commands.valueOf(interpreter.name()).execute(interpreter);
		}
	}
}
