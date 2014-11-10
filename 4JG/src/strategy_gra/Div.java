package strategy_gra;
// Implements the algorithm using the strategy interface
public class Div implements Strategy {
 
    public int execute(int a, int b) {
        return a / b;  
    }
}