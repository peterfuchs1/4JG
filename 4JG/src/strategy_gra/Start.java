package strategy_gra;

public class Start {
	public static void main(String[] args){
		Strategy gra[]=new Strategy[5];
		int i=0;
		gra[i++]=new Add();
		gra[i++]=new Sub();
		gra[i++]=new Mul();
		gra[i++]=new Div();
		gra[i++]=new Mod();
		for(Strategy s: gra){
			System.out.println(s.explanation()+":"+s.execute(6, 3));
		}
	}
	
	
}
