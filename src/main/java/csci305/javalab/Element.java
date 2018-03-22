package csci305.javalab;

public abstract class Element
{
	private String name;

	public Element (String inName) {
		name = inName;
	}

	public abstract Outcome compareTo (Element other);

	public String getName() {
		return name;
	}
}