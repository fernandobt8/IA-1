package utilidade;

public enum Token {

	BLANK("_"),
	BLUE("X"),
	GREEN("O");

	private String name;

	Token(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
