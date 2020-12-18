package p4_group_8_repo;


import javafx.scene.image.Image;

public class Life extends StaticActor {
	boolean active;
	public Life(String ImageLink, double size) {
		super(ImageLink, size);
		
		active = true;
	}
	
	public boolean isActive(){
		return active;
	}
	
	public void removeLife() {
		final Image emptyHeart = new Image("file:/src/p4_group_8_repo/EmptyHeart.png", size, size, true, true);
		
		active = false;
		
		setImage(emptyHeart);
	}

}
