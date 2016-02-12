/**
 * Forth Mockito Test
 * Our new scenario is, when foo.questionStrictly() is passed an invalid question, 
 * Foo should throw InvalidQuestion. 
 * 
 * The exception expected is setup using thenThrow() API which accepts the exception to be thrown. 
 * After the setup, bar.questionStrictly() is called with the invalid question. 
 *  Our expected test attribute makes sure that the exception is thrown.
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
public class MockitoHelloWorldExample4 {
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
	
	@Test(expected=InvalidQuestion.class)
	public void throwExceptionIfInvalidQuestion() {
		Bar bar = new Bar();		
		String invalidQuestion = "Invalid question";
		// throw a mocked Exception
		when(foo.questionStrictly("Invalid question")).thenThrow(new InvalidQuestion());
		bar.questionStrictly(foo, invalidQuestion);
	}	
}