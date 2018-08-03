package errors;

import javax.swing.JOptionPane;

public class Error {
	public Error(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
}
