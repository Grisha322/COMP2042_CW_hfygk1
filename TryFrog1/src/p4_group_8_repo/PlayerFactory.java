package p4_group_8_repo;

public class PlayerFactory implements ActorFactory {

	public Actor getActor(String playerName, String imageLink, double size, double xPos, double yPos) {
		Actor actor = null;
		
		final boolean isAnimal = playerName.equalsIgnoreCase("Animal");
		
		if(isAnimal) {
			actor = new Animal(imageLink, size, xPos, yPos);
		}
		
		return actor;
	}

}
