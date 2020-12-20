package p4_group_8_repo;
/**
 * Interface for Actor Factories
 * @author hfygk1
 *
 */
public interface ActorFactory {
	public abstract Actor getActor(String obstacleName, String imageLink, double size);
}
