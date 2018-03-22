package csci305.javalab;

public class Scissors extends Element
{
	public Scissors() {
		super("scissors");
	}
	public Scissors (String name) {
		super (name);
	}

	@Override
	public Outcome compareTo(Element other)
	{
		switch (other.getName()) {
			case "rock":
				return new Outcome("Lose", "Rock breaks scissors.");
			case "paper":
				return new Outcome("Win", "Scissors cut paper.");
			case "scissors":
				return new Outcome("Tie", "Scissors cut each other.");
			case "lizard":
				return new Outcome("Win", "Scissors decapitate lizard. :(");
			case "Spock":
				return new Outcome("Lose", "Spock smashes scissors.");
			default:
				return new Outcome("Tie", "Jay is an idiot.");
		}
	}
}
