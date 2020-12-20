package p4_group_8_repo;

/**
 * This is a factory that produces static actors
 * @author hfygk1
 *
 */
public class StaticFactory implements ActorFactory{

	public Actor getActor(String staticActorName, String imageLink, double size) {
		Actor actor = null;
		
		final boolean isFinal = staticActorName.equalsIgnoreCase("Final");
		
		final boolean isDigit = staticActorName.equalsIgnoreCase("Digit");
		
		final boolean isLife = staticActorName.equalsIgnoreCase("Life");
		
		if(isFinal) {
			actor = new Final(imageLink, size);
		}
		else if(isDigit) {
			actor = new Digit(imageLink, size);
		}
		else if(isLife) {
			actor = new Life(imageLink, size);
		}
		
		return actor;
	}
}
