package strategy_gra;
// Implements the algorithm using the strategy interface
public class Mul implements Strategy {
 
    public int execute(int a, int b) {
        return a * b;  // Do an addition with a and b
    }

	@Override
	public String explanation() {
		return "Multiply";
	}
}