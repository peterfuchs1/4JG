package timer;
public enum Zustand {
	StundenEinstellen, MinutenEinstellen, SekundenEinstellen;

	
    private static Zustand[] vals = values();
    /**
     * which is the next day from today?
     * @return the next day
     */
    public Zustand next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
    /**
     * which is the previous day from today?
     * @return the previous day
     */
    public Zustand previous()
    {
        return vals[(this.ordinal()+vals.length-1) % vals.length];
    }
}