package csci305.javalab;

public class Outcome
{
	private String description, value;

	public Outcome (String inVal, String inDesc)
	{
		description = inDesc;
		value = inVal;
	}

	public String getOutcome() {
		return value;
	}
	public String toString() {
		return description;
	}
}
