package csci305.javalab;

public class Lizard extends Element
{
	public Lizard() {
		super("lizard");
	}
	public Lizard (String name) {
		super (name);
	}

	@Override
	public Outcome compareTo(Element other)
	{
		switch (other.getName()) {
			case "rock":
				return new Outcome("Lose", "Rock crushes lizard. :(");
			case "paper":
				return new Outcome("Win", "Lizard eats paper. :)");
			case "scissors":
				return new Outcome("Lose", "Scissors decapitate lizard. :(");
			case "lizard":
				return new Outcome("Tie", "Lizards play together. :)");
			case "Spock":
				return new Outcome("Win", "Lizard poisons Spock.");
			default:
				return new Outcome("Tie", "Jay is an idiot.");
		}
	}
}
