package org.example;

import java.util.Scanner;

public class Main {
	/**
	 * 	Exit the program by the word EXIT
	 */
    public static void main(String[] args) {
		CharCounter charCounter = new CharCounter();

		while (true){
			Scanner scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();
			charCounter.isMustShutdownApp(inputString);
			System.out.println(charCounter.countingChars(inputString));
		}
	}
}
