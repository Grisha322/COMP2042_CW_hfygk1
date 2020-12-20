package p4_group_8_repo;

/**
 * Subclass that describes obstacles that constantly moving with s predefined speed
 * @author hfygk1
 *
 */
public class MovingObstacle extends MovingActor {
	protected double speed;
	/**
	 * Overriding act mehod from Actor base class
	 */
	@Override
	public void act() {
		
		moveX(speed);
		
		HandleOutOfBoundsEvent();
		
	}
	
	public MovingObstacle(String imageLink, double size, double speed) {
		
		super(imageLink, size);
		
		this.speed = speed;
	}
	
	/**
	 * Accessing speed of an obstacle
	 * @return returns speed of an obstacle
	 */
	public double getSpeed() {
		
		return speed;
		
	}
	
	/**
	 * Setting speed of an obstacle
	 * @param speed of an obstacle
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * Overriding handle out of bounds method from a moving actor superclass
	 */
	@Override
	public void HandleOutOfBoundsEvent() {
		
		if (getX() > 600 + size && speed > 0)
			setX(-size);
		
		if (getX() < - size && speed < 0)
			setX(600 + size);
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "Obstacle";
		
	}

}
