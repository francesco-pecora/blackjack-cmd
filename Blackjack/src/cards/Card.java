package cards;

public class Card {

	
	// CLASS ATTRIBUTES
	
	private String name;
	private int value;
	
	
	// CLASS CONSTRUCTORS
	
	public Card(String n, int v) {
		setName(n);
		setValue(v);
	}

	
	// GETTERS AND SETTERS
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}
}
