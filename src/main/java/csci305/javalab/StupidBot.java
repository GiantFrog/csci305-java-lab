package csci305.javalab;

public class StupidBot extends Player
{
	public StupidBot() {
		super ("Stupid Bot");
	}
	public StupidBot (String name) {
		super (name);
	}
	public void takeOpponentMove (Element move) {
		//don't do anything with it
	}

	public Element play()
	{
		return RPSLS.moves.get("Lizard");
		//Lizard is the superior choice.
	}
}
