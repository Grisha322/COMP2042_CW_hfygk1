package p4_group_8_repo;


/**
 * Subclass describes logs
 * @author hfygk1
 *
 */
public class Log extends MovingObstacle {

	public Log(String imageLink, double size, double speed) {
		
		super(imageLink, size, speed);
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "Log";
		
	}
	
}
