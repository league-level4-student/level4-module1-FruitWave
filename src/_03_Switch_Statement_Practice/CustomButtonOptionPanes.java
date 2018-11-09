package _03_Switch_Statement_Practice;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];

		// use a switch statement to do something cool for each option
		switch (input) {
		case 0:
			System.out.println("sun");
			break;
		case 1:
			System.out.println("mun");
			break;
		case 2:
			System.out.println("tun");
			break;
		case 3:
			System.out.println("wun");
			break;
		case 4:
			System.out.println("thun");
			break;
		case 5:
			System.out.println("fun");
			break;
		case 6:
			System.out.println("SANS IS HERE");
			break;
		default:
			break;
		}
	}
}
