package qtgame;

public class Statistics {
	private int size;
	private int open;
	private int correct;
	private int wrong;
	private int sum;
	private int games;

	public Statistics(int size) {
		this.size = size;
	}

	public void newGame() {
		this.open = this.size;
		this.correct = 0;
		this.wrong = 0;
		this.sum = 0;
		this.games += 1;
	}

	public void correctClick() {
		this.open -= 1;
		this.correct += 1;
		this.sum += 1;
	}

	public void wrongClick() {
		this.wrong += 1;
		this.sum += 1;
	}

	public String openStr() {
		return "" + this.open;
	}

	public String correctStr() {
		return "" + this.correct;
	}

	public String wrongStr() {
		return "" + this.wrong;
	}

	public String gamesStr() {
		return "" + this.games;
	}

	public String sumStr() {
		return "" + this.sum;
	}

}
