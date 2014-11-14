package strategy_gra;
// Implements the algorithm using the strategy interface
public class Mod implements Strategy {
 
    public int execute(int a, int b) {
        return a % b;  
    }

	@Override
	public String explanation() {

		return "Modulo";
	}
}