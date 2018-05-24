package models;

public enum Category {
	ARTS(1), COMICS_ILLUSTRATION(2), DESIGN_TECH(3), FILM(4), FOOD_CRAFT(5), GAMES(6), 
	MUSIC(7), PUBLISHING(8);
	
private int value;
	
	Category(int valueOp) {
		value = valueOp;
	}
	
	int getValue() {
		return value;
	}
	void setValue(int value) {
		this.value = value;
	}

	public Category selectByNumber(int value) {
		// TODO Auto-generated method stub
		this.setValue(value);
		return this;
	}
	
	
}
