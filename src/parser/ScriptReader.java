package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScriptReader {
	private File script;

	public ScriptReader(File script) {
		this.script = script;
	}

	public ArrayList<String> parse() {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(this.script));

			ArrayList<String> fileParsed = new ArrayList<String>(0);
			String line;

			while ((line = fileReader.readLine()) != null) {
				fileParsed.add(line);
			}

			fileReader.close();

			return fileParsed;
		} catch (IOException e) {
			new Error(e.getMessage());
		}
		
		return null;
	}
}
