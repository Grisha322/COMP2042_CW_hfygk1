package p4_group_8_repo;


import javafx.scene.image.Image;
/**
 * Specifies Life object
 * @author hfygk1
 *
 */
public class Life extends StaticActor {
	boolean active;
	public Life() {
		active = true;
	}
	
	public Life(String ImageLink, double size) {
		super(ImageLink, size);
		active = true;
	}
	
	/**
	 * Checks if the heart is active
	 * @return returns value of active field
	 */
	public boolean isActive(){
		return active;
	}
	
	/**
	 * Sets current instance to inactive
	 */
	public void removeLife() {
		final Image emptyHeart = new Image("file:/src/p4_group_8_repo/EmptyHeart.png", size, size, true, true);
		
		active = false;
		
		setImage(emptyHeart);
	}

}
