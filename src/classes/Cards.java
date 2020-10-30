package classes;

import java.util.ArrayList;
import java.util.Collections;

public class Cards {

	ArrayList<Card> cards = new ArrayList<>();

	public Cards() {};

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void sort() {
		Collections.sort(cards);
	}

	@Override
	public String toString() {
		return cards.toString();
	}

}