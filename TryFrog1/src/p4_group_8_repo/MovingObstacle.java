package p4_group_8_repo;

public class MovingObstacle extends MovingActor {
	protected double speed;
	@Override
	public void act() {
		
		moveX(speed);
		
		HandleOutOfBoundsEvent();
		
	}
	
	public MovingObstacle(String imageLink, double size, double speed) {
		
		super(imageLink, size);
		
		this.speed = speed;
	}
	
	public double getSpeed() {
		
		return speed;
		
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	@Override
	public void HandleOutOfBoundsEvent() {
		
		if (getX() > 600 + size && speed > 0)
			setX(-size);
		
		if (getX() < - size && speed < 0)
			setX(600 + size);
		
	}
	
	public String getActorClassName() {
		
		return "Obstacle";
		
	}

}
