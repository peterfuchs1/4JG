/**
 * Third Mockito Test
 * We will now add a new method to Bar called question(Foo foo, String question) which takes in a question, 
 * sends it to Foo and then returns us Foo‘s answer.
 *  
 * We will spice it up a bit with a few conditions:
 *   First, we need to make sure Foo is available. 
 *    We will know it is available when foo.greet() returns us “Hello World”.
 *   If Foo is unavailable, Bar will not question Foo any more and instead will throw FooNotAvailable exception.
 *   Foo will answer only certain questions..
 *   Any other question sent, Bar will simply filter it out, 
 *   without requesting Foo for an answer and instead will return “Invalid Question”.
 */
package mock;

import static mock.Foo.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class bar
 * 
 * @author Ram Mokkapaty
 * @author uhs374h
 * @version 1.0
 */
public class MockitoHelloWorldExample3 {
	private Foo foo;
	
	@Before
	public void setupMock() {		
		foo = mock(Foo.class);
		when(foo.greet()).thenReturn(HELLO_WORLD);
	}
	
	@Test
	public void fooGreets() {
		// Foo greets: " + foo.greet()
		assertEquals(HELLO_WORLD, foo.greet());
	}
	
	@Test
	public void barGreets() {
		Bar bar = new Bar();
		assertEquals(HELLO_WORLD, bar.greet(foo));
	}
	
	@Test(expected=FooNotAvailable.class)
	public void fooNotAvailable() {
		Bar bar = new Bar();
		// Foo is down so will not respond
		when(foo.greet()).thenReturn(null);
		// Bar sends a question to Foo but since Foo is not available will throw FooNotAvailable
		bar.question(foo, "Hello Foo");	
	}
	
	@Test
	public void barQuestionsFoo() {
		Bar bar = new Bar();
		// Bar asks Foo 'Any new topics?', it should get a response 
		bar.question(foo, Foo.ANY_NEW_TOPICS);	
		// Verify that Foo has been asked the question
		verify(foo, times(1)).question(Foo.ANY_NEW_TOPICS);		
	}
	
	@Test
	public void filterInvalidQuestions() {
		Bar bar = new Bar();		
		String invalidQuestion = "Invalid question";
		bar.question(foo, invalidQuestion);	
		// Verify that question was never requested as Foo is un-available
		verify(foo, never()).question(invalidQuestion);
	}
}