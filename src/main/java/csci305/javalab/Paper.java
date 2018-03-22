package csci305.javalab;

public class Paper extends Element
{
	public Paper() {
		super("paper");
	}
	public Paper (String name) {
		super (name);
	}

	@Override
	public Outcome compareTo(Element other)
	{
		switch (other.getName()) {
			case "rock":
				return new Outcome("Win", "Paper covers rock.");
			case "paper":
				return new Outcome("Tie", "Paper stacks on paper.");
			case "scissors":
				return new Outcome("Lose", "Scissors cut paper.");
			case "lizard":
				return new Outcome("Lose", "Lizard eats paper. :)");
			case "Spock":
				return new Outcome("Win", "Paper disproves Spock.");
			default:
				return new Outcome("Tie", "Jay is an idiot.");
		}
	}
}
