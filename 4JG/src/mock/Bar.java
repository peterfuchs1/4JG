package mock;
/**
 * Test a class using not implemented methods!
 * 
 * @author uhs374h
 *
 */
public class Bar {
	/**
	 * Get a Foo object and make a greet
	 * 
	 * @param foo
	 * @return
	 */
	public String greet(Foo foo) {
		System.out.println("Bar invokes Foo.greet");
		return foo.greet();
	}
	/**
	 * Get a Foo object and a question and return the response
	 * 
	 * @param foo
	 * @param question
	 * @return response or "Invalid question"
	 */
	public String question(Foo foo, String question) {
		verifyFooConnection(foo);
		if (Foo.ANY_NEW_TOPICS.equals(question)) {
			return foo.question(question);
		}
		return "Invalid Question";
	}
	/**
	 * verfiy whether a Foo is available or not
	 * 
	 * @param foo
	 * @throws FooNotAvailable
	 */
	public boolean verifyFooConnection(Foo foo) throws FooNotAvailable {
		System.out.println("Is Foo available?");
		String response = foo.greet();
		if (!Foo.HELLO_WORLD.equals(response)) {
			System.out.println("No");
			throw new FooNotAvailable();
		}
		System.out.println("Yes");
		return true;
	}
	/**
	 * Get a Foo object and a question and return the response 
	 * 
	 * @param foo
	 * @param question
	 * @return response
	 * @throws InvalidQuestion
	 */
	public String questionStrictly(Foo foo, String question) throws InvalidQuestion {
		verifyFooConnection(foo);
		String answer= foo.questionStrictly(question);
		switch (answer) {
		case Foo.NO_NEW_TOPIC:
			System.out.println("No");
			System.out.println("Let's quit now");
			foo.bye();
			break;
		case Foo.YES_NEW_TOPICS_AVAILABLE:
			System.out.println("Yes");
			System.out.println(Foo.WHAT_IS_TODAYS_TOPIC);
			answer = foo.questionStrictly(Foo.WHAT_IS_TODAYS_TOPIC);
			System.out.println("Topic name is " + answer);
			System.out.println("What is the price?");
			int price = foo.getPrice(answer);
			System.out.println("Price is " + price); 
			System.out.println("Let's quit now");
			foo.bye();
			answer = "Topic is " + answer + ", price is " + price;
			break;
		default:
			System.out.println("Answer is " + answer);
			break;
		}
		return answer;
	}

}