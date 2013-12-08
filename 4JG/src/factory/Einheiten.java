package factory;

public enum Einheiten{
	STK("Stk"),KG("kg"),G("g"),L("l"),ML("ml"),M("m"),CM("cm");
	private String code;
	private Einheiten(String code){
		this.code=code;
	}
	public String getCode(){
		return code;
	}
}
