package p4_group_8_repo;

public class Log extends Obstacle {

	public Log(String imageLink, double size, double xpos, double ypos, double speed) {
		
		super(imageLink, size, xpos, ypos, speed);
		
	}
	
	public boolean getLeft() {
		
		return speed < 0;
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "Log";
		
	}
	
}
