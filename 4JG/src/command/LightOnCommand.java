package command;

public class LightOnCommand implements Command {
	private Light light;
	private int prevLevel;

	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	@Override  
	public void undo() {
		light.off(prevLevel);
	}

	@Override
	public void redo() {
		prevLevel=light.getLevel();
		light.on();
	}
}
