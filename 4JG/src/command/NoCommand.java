package command;
public class NoCommand implements Command {

	@Override
	public void redo() {System.out.println("NoCommand can't be redone!");}

	@Override
	public void undo() {System.out.println("NoCommand can't be undone!");}

}
