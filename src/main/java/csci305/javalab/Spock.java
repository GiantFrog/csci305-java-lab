package csci305.javalab;

public class Spock extends Element
{
	public Spock() {
		super("Spock");
	}
	public Spock (String name) {
		super (name);
	}

	@Override
	public Outcome compareTo(Element other)
	{
		switch (other.getName()) {
			case "rock":
				return new Outcome("Win", "Spock vaporizes rock.");
			case "paper":
				return new Outcome("Lose", "Paper disproves Spock.");
			case "scissors":
				return new Outcome("Win", "Spock smashes scissors.");
			case "lizard":
				return new Outcome("Lose", "Lizard poisons Spock.");
			case "Spock":
				return new Outcome("Tie", "Spock stares at Spock.");
			default:
				return new Outcome("Tie", "Jay is an idiot.");
		}
	}
}
