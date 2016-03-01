package command;

import java.util.*;
/**
 * Control commands with a stack for undo and redo functionality
 * @author uhs374h
 * @version 2016-03-01
 */
public class CommandControl implements Command{
	private Stack<Command> undoStack;
	private Stack<Command> redoStack;
	/**
	 * Constructor: create two stacks
	 */
	public CommandControl() {
		undoStack = new Stack<Command>() ;
		redoStack = new Stack<Command>() ;
	}

	/**
	 * redo the last command:
	 * pop the a command from the redoStack
	 * execute the redo method
	 * push the command to the undoStack
	 */	
	public void redo() {
		if(!redoStack.isEmpty()){
			Command c=redoStack.pop();
			c.redo();
			undoStack.push(c);
		}
		
	}
	/**
	 * undo the last command:
	 * pop the a command from the undoStack
	 * execute the undo method
	 * push the command to the redoStack
	 */
	public void undo() {
		if(!undoStack.isEmpty()){
			Command c=undoStack.pop();
			c.undo();
			redoStack.push(c);
		}
	}
	/**
	 * Execute a given command
	 * @param c command to execute
	 */
	public void execute(Command c){
		redoStack.add(c);
		redo();
	}
	/**
	 * clear command history
	 */
	public void clearHistory(){
		undoStack.clear();
		redoStack.clear();
	}
	
}
