/**
 * Fifth Mockito Test
 * Mock objects return expected values. 
 * But when it needs to return different values for different arguments, 
 * Mockito’s argument matcher comes into play. 
 * 
 * In our case, the system has to behave in one way if the questions asked are valid ones and 
 *  in a different way if they are ‘invalid’ which the collaborator doesn’t know how to respond.
 *  
 *  MockitoAnnotations.initMocks(this); initializes fields annotated with Mockito annotations.
 *
 *   Allows shorthand creation of objects required for testing.
 *   Minimizes repetitive mock creation code.
 *   Makes the test class more readable.
 *   Makes the verification error easier to read because field name is used to identify the mock.
 */
package mock;

import static mock.Foo.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


import org.mockito.MockitoAnnotations;
/**
 * Test class bar
 * 
 * @author Ram Mokkapaty
 * @author uhs374h
 * @version 1.0
 */

public class MockitoHelloWorldExample5 {
	// shorthand creation of objects required for testing.
	// foo = mock(Foo.class);
	@Mock
	private Foo foo;
	/**
	 * Create a customized argument matcher for invalid questions.
	 *  
	 * @author uhs374h
	 *
	 */
	private static class InValidQuestions extends ArgumentMatcher<String> {
		/**
		 * test an argument against the valid list in Foo
		 * 
		 * @param o argument to match
		 * @return doesn't match the valid list of questions
		 */
		@Override
		public boolean matches(Object o) {
			String argument=(String)o;
			return !VALID_QUESTIONS.matches(argument);
		}
	}

	/**
	 * Create a customized argument matcher for valid questions.
	 *  
	 * @author uhs374h
	 *
	 */
	private static class ValidQuestions extends ArgumentMatcher<String> {
		/**
		 * test an argument against the valid list in Foo
		 * 
		 * @param o argument to match
		 * @return matches the valid list of questions
		 */
		@Override
		public boolean matches(Object o) {
			String argument=(String)o;
			return argument.equals(Foo.ANY_NEW_TOPICS)
					|| argument.equals(Foo.WHAT_IS_TODAYS_TOPIC);
		}
	}
	/**
	 * Class to to be used for configuring Foo's answer. 
	 * Answer specifies an action that is executed and 
	 * a return value that is returned when you interact with the mock. 
	 * 
	 * @author uhs374h
	 *
	 */
	private static class FooAnswers implements Answer<String> {
		public String answer(InvocationOnMock invocation) throws Throwable, InvalidQuestion {
			String arg = (String) invocation.getArguments()[0];
			
			switch(arg){
			case Foo.ANY_NEW_TOPICS: 
				return Foo.YES_NEW_TOPICS_AVAILABLE;
			case Foo.WHAT_IS_TODAYS_TOPIC: 
				return Foo.TOPIC_MOCKITO;
			default: 
				throw new InvalidQuestion();
			}
		}
	}

	private final static ValidQuestions VALID_QUESTIONS = new ValidQuestions();
	
	
	@Before
	public void setupMockTests() {		
		// Initialize annotations for mockito
		MockitoAnnotations.initMocks(this);
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
		// Verify that question was never requested as Foo is unavailable
		verify(foo, never()).question(invalidQuestion);
	}
	
	@Test(expected=InvalidQuestion.class)
	public void throwExceptionIfInvalidQuestion(){
		Bar bar = new Bar();		
		String invalidQuestion = "Invalid question";
		// throw a mocked Exception
		when(foo.questionStrictly("Invalid question")).thenThrow(new InvalidQuestion());
		bar.questionStrictly(foo, invalidQuestion);
	}
	
	@Test(expected=InvalidQuestion.class)
	public void throwExceptionIfAnyInvalidQuestion(){
		Bar bar = new Bar();
		String invalidQuestion = "Invalid question";
		// use our new ArgumentMatcher and match it against valid questions
		when(foo.questionStrictly(argThat(new InValidQuestions()))).thenThrow(
				new InvalidQuestion());
		bar.questionStrictly(foo, invalidQuestion);
	}


	@Test
	public void getTodaysTopicAndPriceWithAnyNewTopic() {
		Bar bar = new Bar();
		when(foo.questionStrictly(argThat(new ValidQuestions()))).thenAnswer(
				new FooAnswers());
		when(foo.getPrice(TOPIC_MOCKITO)).thenReturn(20);

		String answer = bar.questionStrictly(foo, ANY_NEW_TOPICS);
		// Answer is: Topic is Mockito, price is 20
		assertEquals(answer, "Topic is Mockito, price is 20");
		// Not only the answer is important, but the behavior too
		verify(foo, times(1)).questionStrictly(WHAT_IS_TODAYS_TOPIC);
		verify(foo, times(1)).getPrice(TOPIC_MOCKITO);
		verify(foo, times(1)).bye();
	}

	@Test
	public void getTodaysTopicWithWhatIsTodaysTopic() {
		Bar bar = new Bar();
		when(foo.questionStrictly(argThat(new ValidQuestions()))).thenAnswer(
				new FooAnswers());

		String answer = bar.questionStrictly(foo, WHAT_IS_TODAYS_TOPIC);
		// Answer is: Mockito
		assertEquals(answer, TOPIC_MOCKITO);
		// Not only the answer is important, but the behavior too
		verify(foo, times(1)).questionStrictly(WHAT_IS_TODAYS_TOPIC);
		verify(foo, never()).questionStrictly(ANY_NEW_TOPICS);
		verify(foo, never()).getPrice(TOPIC_MOCKITO);
		verify(foo, never()).bye();
	}
	
	@Test(expected=InvalidQuestion.class)
	public void getTodaysTopicWithWrongQuestion() {
		Bar bar = new Bar();
		String invalidQuestion = "Invalid question";
		when(foo.questionStrictly(argThat(new InValidQuestions()))).thenAnswer(
				new FooAnswers());

		bar.questionStrictly(foo, invalidQuestion);
		// this is not reachable!
//		verify(foo, never()).questionStrictly(WHAT_IS_TODAYS_TOPIC);
//		verify(foo, never()).questionStrictly(ANY_NEW_TOPICS);
//		verify(foo, never()).getPrice(TOPIC_MOCKITO);
//		verify(foo, never()).bye();
	}
	

	
	@Test
	public void noNewTopic() {
		Bar bar = new Bar();
		when(foo.questionStrictly(ANY_NEW_TOPICS)).thenReturn(NO_NEW_TOPIC);

		String answer = bar.questionStrictly(foo, ANY_NEW_TOPICS);
		// Answer is: No
		assertEquals(answer, NO_NEW_TOPIC);
		// Not only the answer is import, but the behavior too
		verify(foo, times(1)).bye();
		verify(foo, never()).questionStrictly(WHAT_IS_TODAYS_TOPIC);
		verify(foo, never()).getPrice(TOPIC_MOCKITO);
	}


}