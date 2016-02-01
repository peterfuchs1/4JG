package atdd9;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


	 
public class StringCalculatorTest {
		
	
	    @Test
	    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
	        int actual=StringCalculator.add("1,2,3");
	        int expected=6;
	        assertEquals(expected, actual);
	    }
	    
	    @Test(expected = RuntimeException.class)
	    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
	        StringCalculator.add("3,-6,15,18,46,33");
	    }
	    @Test
	    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
	        RuntimeException exception = null;
	        try {
	            StringCalculator.add("3,-6,15,-18,46,33");
	        } catch (RuntimeException e) {
	            exception = e;
	        }
	        assertNotNull(exception);
	        assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
	    }
	    
	    @Test
	    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
	        StringCalculator.add("1,2");
	        assertTrue(true);
	    }
	    @Test(expected = RuntimeException.class)
	    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
	        StringCalculator.add("1,X");
	    }
	    
	    @Test
	    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
	        assertEquals(3+1000+6, StringCalculator.add("3,1000,1001,6,1234"));
	    }
	    @Test
	    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSumDelimSemicolon() {
	        assertEquals(3+1000+6, StringCalculator.new_add("3;1000;1001;6;1234"));
	    }
}
