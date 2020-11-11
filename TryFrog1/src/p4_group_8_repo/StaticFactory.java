package p4_group_8_repo;

public class StaticFactory implements ActorFactory{

	public Actor getActor(String staticActorName, String imageLink, double size, double xPos, double yPos) {
		Actor actor = null;
		
		final boolean isFinal = staticActorName.equalsIgnoreCase("Final");
		
		final boolean isDigit = staticActorName.equalsIgnoreCase("Digit");
		
		if(isFinal) {
			actor = new Final(imageLink, size, xPos, yPos);
		}
		else if(isDigit) {
			actor = new Digit(imageLink, size, xPos, yPos);
		}
		
		return actor;
	}
}
