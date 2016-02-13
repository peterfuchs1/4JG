package mock;

public interface Foo {
	public final static String HELLO_WORLD = "Hello World";
	public String greet();
	
	public final static String ANY_NEW_TOPICS = "Are there any new topics?";	
	public String question(String question);
	
	public String questionStrictly(String question) throws InvalidQuestion;
	
	public final static String WHAT_IS_TODAYS_TOPIC = "What is todays topic?";

	public final static String YES_NEW_TOPICS_AVAILABLE = "Yes";
	public final static String NO_NEW_TOPIC = "No";
	public final static String TOPIC_MOCKITO = "Mockito";

	public int getPrice(String tutorial);

	public void bye();
}
