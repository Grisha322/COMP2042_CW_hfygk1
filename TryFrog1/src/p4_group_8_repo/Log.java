package p4_group_8_repo;

public class Log extends MovingObstacle {

	public Log(String imageLink, double size, double speed) {
		
		super(imageLink, size, speed);
		
	}
	
	public boolean getLeft() {
		
		return speed < 0;
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "Log";
		
	}
	
}
