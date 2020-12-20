package p4_group_8_repo;

/**
 * This is a factory class that produces Moving obstacles
 * @author hfygk1
 *
 */
public class MovingObstalceFactory implements ActorFactory{
	private double speed = 0;
	
	/**
	 * Setting speed of a moving obstacle to be created. Speed must be set before calling getActor 
	 * @param speed speed of the moving obstacle to be created
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * This method returns an instance of a specified moving obstacle
	 */
	public Actor getActor(String obstacleName, String imageLink, double size) {
		Actor obstacle = null;
		
		final boolean isLog = obstacleName.equalsIgnoreCase("Log");
		
		final boolean isCar = obstacleName.equalsIgnoreCase("Car");
		
		final boolean isTurtle = obstacleName.equalsIgnoreCase("Turtle");
		
		final boolean isWetTurtle = obstacleName.equalsIgnoreCase("WetTurtle");
		
		if(isLog) {
			obstacle = new Log(imageLink, size, speed);
		}
		else if(isCar) {
			obstacle = new Car(imageLink, size, speed);
		}
		else if(isTurtle) {
			obstacle = new Turtle(imageLink, size, speed);
		}
		else if(isWetTurtle) {
			obstacle = new WetTurtle(imageLink, size, speed);
		}
		
		return obstacle;
	}
}
