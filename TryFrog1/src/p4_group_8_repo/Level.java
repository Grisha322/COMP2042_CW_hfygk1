package p4_group_8_repo;

/**
 * This enum is used to hold total amount of levels. It simplifies refferencing to them as well as readability
 * @author hfygk1
 *
 */
public enum Level {
	NOTSET,
	ONE,
	TWO,
	THREE;
	
	/**
	 * This method is used to access next element of enum
	 * @return returns next element in the enum. if there no more lements left, return NOTSET value
	 */
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
	
	/**
	 * This method checks if next element exists
	 * @return returns false if current element is the last, and true otherwise
	 */
	public boolean elementsLeft() {
		return this != Level.THREE;
	}
	
	/**
	 * This method is used to convert Level object to int. Each level corresponds to sum number, e. g. Level one - 1
	 * @return integer associated with each element
	 */
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
