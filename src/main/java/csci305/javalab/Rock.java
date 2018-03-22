package csci305.javalab;

public class Rock extends Element
{
	public Rock() {
		super("rock");
	}
	public Rock (String name) {
		super (name);
	}

	@Override
	public Outcome compareTo(Element other)
	{
		switch (other.getName()) {
			case "rock":
				return new Outcome("Tie", "Rocks remain montionless.");
			case "paper":
				return new Outcome("Lose", "Paper covers rock.");
			case "scissors":
				return new Outcome("Win", "Rock breaks scissors.");
			case "lizard":
				return new Outcome("Win", "Rock crushes lizard. :(");
			case "Spock":
				return new Outcome("Lose", "Spock vaporizes rock.");
			default:
				return new Outcome("Tie", "Jay is an idiot.");
		}
	}
}
