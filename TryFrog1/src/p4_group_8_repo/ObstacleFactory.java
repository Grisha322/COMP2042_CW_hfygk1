package p4_group_8_repo;

public class ObstacleFactory implements ActorFactory{
	private double speed = 0;
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public Actor getActor(String obstacleName, String imageLink, double size, double xPos, double yPos) {
		Actor obstacle = null;
		
		final boolean isLog = obstacleName.equalsIgnoreCase("Log");
		
		final boolean isCar = obstacleName.equalsIgnoreCase("Car");
		
		final boolean isTurtle = obstacleName.equalsIgnoreCase("Turtle");
		
		final boolean isWetTurtle = obstacleName.equalsIgnoreCase("WetTurtle");
		
		if(isLog) {
			obstacle = new Log(imageLink, size, xPos, yPos, speed);
		}
		else if(isCar) {
			obstacle = new Car(imageLink, size, xPos, yPos, speed);
		}
		else if(isTurtle) {
			obstacle = new Turtle(imageLink, size, xPos, yPos, speed);
		}
		else if(isWetTurtle) {
			obstacle = new WetTurtle(imageLink, size, xPos, yPos, speed);
		}
		
		return obstacle;
	}
}
