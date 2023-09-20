package org.example;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharCounterV2Test {

	CharCounterV2 charCounterV2 = new CharCounterV2();
	@Test
	void testDoesCharCountingV2Work() {
		HashMap<Character, Integer> expected = new HashMap<>();
		{
			expected.put('h', 1);
			expected.put('e', 1);
			expected.put('l', 2);
			expected.put('o', 1);
		}
		String input = "hello";

		assertEquals(expected, charCounterV2.countingChars(input));
	}
	@Test
	void testDoesExceptionMessageRight(){
		String input = "";

		try {
			charCounterV2.countingChars(input);
		} catch (IllegalArgumentException e) {
			assertEquals("Input is empty", e.getMessage());
		}
	}
	@Test
	void testDoesExceptionThrowingIfInputEmpty(){
		String input = "";

		assertThrows(IllegalArgumentException.class, ()->  charCounterV2.countingChars(input) );
	}
}
