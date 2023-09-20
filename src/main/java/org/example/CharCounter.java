package org.example;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {

	private final Map<String, String> cache = new HashMap<>();
	private static final String EXIT = "EXIT";

	public String countingChars(String inputString) {
		String validatedInputString = checkEmptyInput(inputString);
		String countedCharacters;

		if (cache.get(validatedInputString) != null ){
			countedCharacters = cache.get(validatedInputString);
		} else {
			Map<Character, Integer> charactersHashMap = new HashMap<>();

			for (int i = 0; i < validatedInputString.length(); i++) {
				char character = validatedInputString.charAt(i);
				int counter = 0;

				for (int j = 0; j < validatedInputString.length(); j++) {
					char charCounter = validatedInputString.charAt(j);

					if (character == charCounter) {
						counter++;
					}
				}
				charactersHashMap.put(character, counter);

			}

			countedCharacters = charactersHashMap.toString();
			cacheData(validatedInputString, countedCharacters);
		}

		return countedCharacters;
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

	private void cacheData(String inputString, String countedCharacters){
		cache.put(inputString,countedCharacters);
	}
}
