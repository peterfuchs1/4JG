package command;

public class DimmerLightOffCommand implements Command {
	private Light light;
	private int prevLevel;

	public DimmerLightOffCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void redo() {
		prevLevel = light.getLevel();
		light.dim(-25);
	}
	@Override
	public void undo() {
		light.setLevel(prevLevel);
	}
}
