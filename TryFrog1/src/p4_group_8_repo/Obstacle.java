package p4_group_8_repo;

public class Obstacle extends MovingActor {
	protected double speed;
	@Override
	public void act() {
		
		move(speed , 0);
		
		HandleOutOfBoundsEvent();
		
	}
	
	public Obstacle(String imageLink, double size, double xPos, double yPos, double speed) {
		
		super(imageLink, size, xPos, yPos);
		
		this.speed = speed;
	}
	
	public double getSpeed() {
		
		return speed;
		
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
