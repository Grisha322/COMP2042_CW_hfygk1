package p4_group_8_repo;

public enum Level {
	NOTSET,
	ONE,
	TWO,
	THREE;
	
	public Level nextElement() {
		Level level = NOTSET;
		if(this == Level.NOTSET)
			level = ONE;
		else if(this == Level.ONE)
			level = TWO;
		else if(this == Level.TWO)
			level = THREE;
		return level;
	}
	
	public boolean elementsLeft() {
		return this != Level.THREE;
	}
	
	public int levelToInt() {
		int number = 0;
		if(this.equals(Level.ONE)) {
			number = 1;
		}
		else if(this.equals(Level.TWO)) {
			number = 2;
		}
		else if(this.equals(Level.THREE)) {
			number = 3;
		}
		else if(this.equals(Level.NOTSET)) {
			number = 0;
		}
		return number;
	}
}
