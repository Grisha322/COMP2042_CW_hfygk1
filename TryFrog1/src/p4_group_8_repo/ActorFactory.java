package p4_group_8_repo;

public interface ActorFactory {
	public abstract Actor getActor(String obstacleName, String imageLink, double size, double xPos, double yPos);
}
