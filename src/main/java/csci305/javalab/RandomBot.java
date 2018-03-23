package csci305.javalab;

public class RandomBot extends Player
{
	public RandomBot() {
		super ("Random Bot");
	}
	public RandomBot (String name) {
		super (name);
	}
	public void takeOpponentMove (Element move) {
		//don't do anything with it
	}

	public Element play()
	{
		return randChoice();	//see Player
	}
}
