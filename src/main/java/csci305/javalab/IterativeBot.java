package csci305.javalab;

public class IterativeBot extends Player
{
	private int plays;
	public IterativeBot() {
		super ("Iterative Bot");
		plays = 0;
	}
	public IterativeBot (String name) {
		super (name);
		plays = 0;
	}
	public void takeOpponentMove (Element move) {
		//don't do anything with it
	}

	public Element play()
	{
		switch (plays%5)		//Start with rock, play the next in line next time, loop back to rock.
		{
			case 0:
				plays++;
				return RPSLS.moves.get("Rock");
			case 1:
				plays++;
				return RPSLS.moves.get("Paper");
			case 2:
				plays++;
				return RPSLS.moves.get("Scissors");
			case 3:
				plays++;
				return RPSLS.moves.get("Lizard");
			case 4:
				plays++;
				return RPSLS.moves.get("Spock");
			default:
				return new Lizard("Jay can't do iteration.");
		}
	}
}
