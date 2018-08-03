import emulator.Malduino;

public class Main {

	public static void main(String[] args) {
//		if (args.length > 0) {
//			new Malduino(args[0]).start();
//		} else {
//			new Error("No file path found. Just draw the file in to the MalduinoEmulator");
//		}
		
		new Malduino().start();
	}

}
