package csci305.javalab;

public abstract class Player
{
	private String name;
	private int score;

	public Player (String inName) {
		name = inName;
		score = 0;
	}

	public abstract Element play();
	public abstract void takeOpponentMove(Element move);

	//any player class can pull a random choice
	Element randChoice()
	{
		switch ((int)(Math.random()*5))
		{
			case 0: return RPSLS.moves.get("Rock");
			case 1: return RPSLS.moves.get("Paper");
			case 2: return RPSLS.moves.get("Scissors");
			case 3: return RPSLS.moves.get("Lizard");
			case 4: return RPSLS.moves.get("Spock");
			default: return new Lizard("Jay can't do random number generation.");
		}
	}

	public void addPoint() {
		score += 1;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}

}
