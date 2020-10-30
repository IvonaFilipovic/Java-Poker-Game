package classes;

public class Card implements Comparable {

	int rank;
	Suit suit;

	public Card(int rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public int compareTo(Object other) {
		return this.rank - ((Card) other).rank;
	}

	@Override
	public String toString() {
		return suit.toString() + switch (rank) {
			case 11 -> "J";
			case 12 -> "Q";
			case 13 -> "K";
			case 1  -> "A";
			default -> rank;
		};
	}

}