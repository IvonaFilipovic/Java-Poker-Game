package classes;

public class Pack extends Cards{

	public Pack() {
		super();
		for (int rank = 1; rank <= 13; rank++) {
			for (Suit suit : Suit.values()) {
				cards.add(new Card(rank, suit));
			}
		}
	}

}