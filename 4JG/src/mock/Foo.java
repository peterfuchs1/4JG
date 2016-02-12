package mock;

public interface Foo {
	public String HELLO_WORLD = "Hello World";
	public String greet();
	
	public String ANY_NEW_TOPICS = "Are there any new topics?";	
	public String question(String question);
	
	public String questionStrictly(String question) throws InvalidQuestion;
	
	public String WHAT_IS_TODAYS_TOPIC = "What is todays topic?";

	String YES_NEW_TOPICS_AVAILABLE = "Yes";
	String NO_NEW_TOPIC = "No";
	String TOPIC_MOCKITO = "Mockito";

	int getPrice(String tutorial);

	void bye();
}
