package estrutura.tabuleiro;

public enum Token {

	BLANK("_", "images/white.png"),
	BLUE("X", "images/blue.png"),
	RED("O", "images/red.png");

	private String name;
	private String images;

	Token(String name, String images) {
		this.name = name;
		this.images = images;
	}

	public String getImage() {
		return this.images;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
