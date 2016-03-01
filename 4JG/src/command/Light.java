package command;

public class Light {
	private String location;
	private int level;

	public Light(String location) {
		this.setLocation(location);
	}

	public void on() {
		this.on(100);
	}
	public void on(int level) {
		level = 100;
		System.out.println(location+": The light is on");
	}
	public void off(int level) {
		level = 0;
		System.out.println(location+": The light is off");
	}
	public void off(){
		this.off(0);
	}
	public void dim(int level) {
		this.level +=level;
		this.level=(this.level<0)?0:this.level;
		this.level=(this.level>100)?100:this.level;

		if (this.level == 0) off();
		else 
			dim();
	}

	public int getLevel() {
		return level;
	}
	
	private void dim(){
		System.out.println(location+": The light is dimmed to " + this.level + "%");
	}
	
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
		dim();
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
