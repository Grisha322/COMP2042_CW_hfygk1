package p4_group_8_repo;

import javafx.scene.image.Image;

public class Final extends StaticActor{
	
	private boolean activated = false;
	
	public Final(String imageLink, double size, double xPos, double yPos) {
		
		super(imageLink, size, xPos, yPos);
		
	}
	
	public void activate() {
		setImage(new Image("file:src/p4_group_8_repo/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	public void deactivate() {
		setImage(ActorImage);
		activated = false;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	@Override
	public String getActorClassName() {
		
		return "Final";
		
	}
}
