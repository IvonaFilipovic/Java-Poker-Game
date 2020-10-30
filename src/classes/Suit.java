package classes;

public enum Suit {

	H, D, C, S;

	@Override
	public String toString() {
		return switch (this) {
			case H -> "♥";
			case D -> "♦";
			case C -> "♣";
			case S -> "♠";
		};
	}

}