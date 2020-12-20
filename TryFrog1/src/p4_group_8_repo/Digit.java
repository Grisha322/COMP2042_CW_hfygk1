package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * Subclass of a static actor that is used to visualize Digits
 * @author hfygk1
 *
 */
public class Digit extends StaticActor{
	public Digit() {}
	
	public Digit(String imgLink, double size) {
		
		super(imgLink, size);
		
	}
	
	
	/**
	 * Change the digit displayed.
	 * @param digit is a number from 0-9 that will be displayed
	 */
	public void setDigit(int digit) throws IllegalArgumentException{
		if(digit < 0 || digit > 9)
			throw new IllegalArgumentException("Parameter must be within the range from 0 - 9");
		final Image digitImage = new Image("file:src/p4_group_8_repo/" + digit + ".png", size, size, true, true);
		setImage(digitImage);
	}
	
	@Override
	public String getActorClassName() {
		
		return "Digit";
		
	}
	
}
