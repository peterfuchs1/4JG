package command;
/**
 * Interface for Commands
 * @author uhs374h
 * @version 2016-03-01
 *  
 */
public interface Command {
	/**
	 * the redo functionality
	 */
	public void redo();
	/**
	 * the undo functionality
	 */
	public void undo();
}
