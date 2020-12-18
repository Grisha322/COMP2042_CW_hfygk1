package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends StaticActor{
	
	public Digit(String imgLink, double size) {
		
		super(imgLink, size);
		
	}
	
	public void setDigit(int digit) {
		final Image digitImage = new Image("file:src/p4_group_8_repo/" + digit + ".png", size, size, true, true);
		setImage(digitImage);
	}
	
	@Override
	public String getActorClassName() {
		
		return "Digit";
		
	}
	
}
