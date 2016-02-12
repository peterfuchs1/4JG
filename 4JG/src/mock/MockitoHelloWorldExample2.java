/**
 * Second Mockito Test
 * We will now add our new test barGreets() which just makes sure that Foo returns us the proper response. 
 * 
 * Since even our second test makes use of the mock object, 
 * we have moved the setting up of mock object to our new configuration method setupMock(), 
 * which is a @Before that gets called right before the invocation of each test method.
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
public class MockitoHelloWorldExample2 {
	private Foo foo;
	
	@Before
	public void setupMock() {		
		foo = mock(Foo.class);
		when(foo.greet()).thenReturn(HELLO_WORLD);
	}
	
	@Test
	public void fooGreets() {
		// System.out.println("Foo greets: " + foo.greet());
		assertEquals(HELLO_WORLD, foo.greet());
	}
	
	@Test
	public void barGreets() {
		Bar bar = new Bar();
		assertEquals(HELLO_WORLD, bar.greet(foo));
	}
}