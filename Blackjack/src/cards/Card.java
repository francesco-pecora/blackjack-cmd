package cards;

public class Card {

	private String name;
	private int value;
	
	public Card(String n, int v) {
		setName(n);
		setValue(v);
	}

	/**
	 * returns the name of the card.
	 * 
	 * @return name : String
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the card.
	 * 
	 * @param name : String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the value of the card.
	 * 
	 * @return value : int
	 */
	public int getValue() {
		return value;
	}

	/**
	 * sets the value of the card.
	 * 
	 * @param value : int
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * custom output for the single card.
	 */
	@Override
	public String toString() {
		return "Card [name=" + name + ", value=" + value + "]";
	}
	
}
