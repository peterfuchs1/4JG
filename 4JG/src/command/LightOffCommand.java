package command;

public class LightOffCommand implements Command {
	private Light light;
	private int prevLevel;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	@Override 
	public void redo() {
        prevLevel = light.getLevel();
		light.off();
	}
	@Override
	public void undo() {
		light.on(prevLevel);
	}
}
