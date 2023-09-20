package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharCounterTest {

	CharCounter charCounter = new CharCounter();
	@Test
	void testDoesCharCountingWork() {
		String expected = "{ =1, r=1, d=1, e=1, w=1, h=1, l=3, o=2}";
		String input = "hello world";

		assertEquals(expected, charCounter.countingChars(input));
	}
	@Test
	void testDoesExceptionMessageRight(){
		String input = "";

		try {
			charCounter.countingChars(input);
		} catch (IllegalArgumentException e) {
			assertEquals("Input is empty", e.getMessage());
		}
	}
	@Test
	void testDoesExceptionThrowingIfInputEmpty(){
		String input = "";

		assertThrows(IllegalArgumentException.class, ()->  charCounter.countingChars(input) );
	}
}
