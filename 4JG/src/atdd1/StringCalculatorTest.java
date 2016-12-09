package atdd1;

import static org.junit.Assert.*;

import org.junit.Test;


	 
public class StringCalculatorTest {
		
	
	    @Test(expected = RuntimeException.class)
	    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
	        StringCalculator.add("1,2,3");
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

}
