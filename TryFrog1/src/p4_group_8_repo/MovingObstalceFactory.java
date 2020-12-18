package p4_group_8_repo;

public class MovingObstalceFactory implements ActorFactory{
	private double speed = 0;
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
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
