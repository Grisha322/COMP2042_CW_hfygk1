package p4_group_8_repo;

public abstract class MovingActor extends Actor{
	
	public MovingActor(String ImageLink, double size) {
		super(ImageLink, size);
	}
	
	public void moveX(double dx) {
        setX(getX() + dx);
    }
	
	public void moveY(double dy) {
		setY(getY() + dy);
	}
	
	public void move(double dx, double dy) {
		moveX(dx);
		moveY(dy);
	}
	
	public abstract void HandleOutOfBoundsEvent();
}
