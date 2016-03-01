package command;

public class TestCommandControl {
	public static void main(String[] args) {
		Light  light = new Light("livingroom");
		CommandControl control=new CommandControl();

		// turn on the light
		control.execute(new LightOnCommand(light));
		// dim to 25%
		control.execute(new DimmerLightOnCommand(light));
		// dim to 50%
		control.execute(new DimmerLightOnCommand(light));
		// dim to 75%
		control.execute(new DimmerLightOnCommand(light));
		// undo the last command: dim to 50%
		control.undo();
		// redo the last command: dim to 75%
		control.redo();
		// dim to 50%
		control.execute(new DimmerLightOffCommand(light));
		// Nothing to do
		control.execute(new NoCommand());
		// undo the last command: Nothing to do
		control.undo();
		// undo the last command: dim to 75%
		control.undo();
		// undo the last command: dim to 50%
		control.undo();
		// undo the last command: dim to 25%		
		control.undo();
		// undo the last command: dim to 0%
		control.undo();
		// undo the last command: swtich off the light
		control.undo();
		// undoStack is empty!
		control.undo();
		}


}
