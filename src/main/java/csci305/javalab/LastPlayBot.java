package csci305.javalab;

public class LastPlayBot extends Player
{
	private Element lastPlay;

	public LastPlayBot()
	{
		super("Copycat Bot");
		lastPlay = randChoice();		//initialize with a random first move

	}
	public LastPlayBot (String name)
	{
		super (name);
		lastPlay = randChoice();
	}


	public void takeOpponentMove (Element move) {
		lastPlay = move;				//take note of what the opponent just played
	}
	public Element play() {
		return lastPlay;				//play whatever the last play was
	}
}