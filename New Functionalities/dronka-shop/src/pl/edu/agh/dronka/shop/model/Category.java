package pl.edu.agh.dronka.shop.model;

public enum Category {

	BOOKS("Książki"), ELECTRONICS("Elektronika"), FOOD("Żywność"), MUSIC("Muzyka"), SPORT("Sport");

	private final String displayName;

	public String getDisplayName() {
		return displayName;
	}

	Category(String displayName) {
		this.displayName = displayName;
	}
}
