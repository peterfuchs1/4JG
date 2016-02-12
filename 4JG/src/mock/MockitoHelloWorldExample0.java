/**
 * First Mockito Test
 * Our first scenario would be to call foo.greet() and make it return “Hello World”. 
 * This will introduce us to concepts like mocking and training the mock object.
 * Our test consists of:
 *  Creating a mock Foo object
 *   and then train it to return us “Hello World” when Foo.greet() is called. 
 *   This will set up the expectations that we have from the mock object.
 * 
 */
package mock;
// to get our String too
import static mock.Foo.*;
import static org.junit.Assert.*;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

/**
 * Test the interface Foo
 * 
 * @author Ram Mokkapaty
 * @author uhs374h
 * @version 1.0
 */
public class MockitoHelloWorldExample0 {
	
	@Mock
	private Foo foo;

	@Before
	public void setupMockTests() {		
		// Initialize annotations for mockito
		MockitoAnnotations.initMocks(this);
		when(foo.greet()).thenReturn(HELLO_WORLD).thenReturn(" and good bye!");
	}
	
	@Test
	public void fooGreets() {
		assertEquals(foo.greet(), HELLO_WORLD);
	}
	
	@Test
	public void fooGreetsToTimes() {
		String expected=HELLO_WORLD+" and good bye!";
		String actual= foo.greet();
		assertEquals(expected, actual+foo.greet());
	}

}
