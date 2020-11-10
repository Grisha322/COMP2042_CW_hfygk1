package p4_group_8_repo;

public abstract class MovingActor extends Actor{
	
	public MovingActor(String ImageLink, double size, double xPos, double yPos) {
		super(ImageLink, size, xPos, yPos);
	}
	
	public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
	
	public abstract void HandleOutOfBoundsEvent();
}
