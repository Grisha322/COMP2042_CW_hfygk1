package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * Subclass that describes finishing boxes.
 * @author hfygk1
 *
 */
public class Final extends StaticActor{
	private boolean activated;
	public Final() {
		activated = false;
	}
	
	public Final(String imageLink, double size) {
		super(imageLink, size);
		activated = false;
	}
	
	/**
	 * Activating final
	 */
	public void activate() {
		setImage(new Image("file:src/p4_group_8_repo/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	/**
	 * Deactivating final
	 */
	public void deactivate() {
		setImage(ActorImage);
		activated = false;
	}
	
	/**
	 * Checking if final is active
	 * @return returns value of activated field
	 */
	public boolean isActivated() {
		return activated;
	}
	
	@Override
	public String getActorClassName() {
		
		return "Final";
		
	}
}
