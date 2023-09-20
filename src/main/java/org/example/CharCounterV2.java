package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class CharCounterV2 {
	public static void main(String[] args) {
		CharCounterV2 charCounterV2 = new CharCounterV2();

		while (true){
			Scanner scanner = new Scanner(System.in);
			String inputString = scanner.nextLine();
			charCounterV2.isMustShutdownApp(inputString);
			charCounterV2.outputResult(charCounterV2.countingChars(inputString));
		}
	}

	private final Map<String, HashMap<Character, Integer>> cache = new HashMap<>();
	private static final String EXIT = "EXIT";

	private void outputResult(Map<Character, Integer> charactersHashMap){
		for (Map.Entry<Character, Integer> entry : charactersHashMap.entrySet()) {
			System.out.println( "\"" + entry.getKey() + "\"" + " - " + entry.getValue());
		}
	}

	public Map<Character, Integer> countingChars(String inputSting){
		String validatedInputString = checkEmptyInput(inputSting);
		HashMap<Character, Integer> charactersHashMap = new HashMap<>();
		ArrayList<Character> charactersList = new ArrayList<>();

		if (cache.get(validatedInputString) != null ){
			charactersHashMap = cache.get(validatedInputString);
		} else {
			for (int i = 0; i < validatedInputString.length(); i++) {
				charactersList.add(validatedInputString.charAt(i));
			}

			for (int i = 0; i < validatedInputString.length(); i++) {
				charactersHashMap.putIfAbsent(charactersList.get(i),
					Collections.frequency(charactersList, charactersList.get(i)));
			}

			cacheData(validatedInputString, charactersHashMap);
		}

		return charactersHashMap;
	}

	public void isMustShutdownApp(String inputString){
		if (inputString.equals(EXIT)){
			System.exit(0);
		}
	}

	private String checkEmptyInput(String inputString) {
		if (inputString.isEmpty()) {
			throw new IllegalArgumentException("Input is empty");
		}

		return inputString.toLowerCase();
	}

	private void cacheData(String validatedinputString, HashMap<Character, Integer> charactersHashMap){
		cache.put(validatedinputString, charactersHashMap);
	}
}
