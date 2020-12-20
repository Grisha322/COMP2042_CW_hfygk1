package p4_group_8_repo;

/**
 * Adds movement ability to a base class actor
 * @author hfygk1
 *
 */
public abstract class MovingActor extends Actor{
	
	public MovingActor(String ImageLink, double size) {
		super(ImageLink, size);
	}
	
	/**
	 * This is a method to move horizontally
	 * @param dx horizontal shift
	 */
	public void moveX(double dx) {
        setX(getX() + dx);
    }
	
	/**
	 * this is a method to move vertically
	 * @param dy vertical shift
	 */
	public void moveY(double dy) {
		setY(getY() + dy);
	}
	
	/**
	 * This is a method to move in a 2d plane
	 * @param dx horizontal shift
	 * @param dy vertical shift
	 */
	public void move(double dx, double dy) {
		moveX(dx);
		moveY(dy);
	}
	
	public abstract void HandleOutOfBoundsEvent();
}
