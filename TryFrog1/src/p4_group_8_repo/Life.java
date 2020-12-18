package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Life extends StaticActor {
	private static List<Life> lifes = new ArrayList<Life>();
	boolean active;
	public Life(String ImageLink, double size) {
		super(ImageLink, size);
		
		active = true;
		
		final int index = 0;
		
		lifes.add(index, this);
	}
	
	private boolean isActive(){
		return active;
	}
	
	private void remove() {
		final Image emptyHeart = new Image("file:/src/p4_group_8_repo/EmptyHeart.png", size, size, true, true);
		
		active = false;
		
		setImage(emptyHeart);
	}
	
	public static void removeLife() {
		for(Life life: lifes) {
			if(life.isActive()) {
				life.remove();
				return;
			}
		}
	}
	
	public static int lifesLeft() {
		int counter = 0;
		for(Life life: lifes) {
			if(life.isActive()) {
				counter++;
			}
		}
		return counter;
	}

}
