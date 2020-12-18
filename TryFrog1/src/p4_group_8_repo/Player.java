package p4_group_8_repo;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public abstract class Player extends MovingActor {
	
	protected final double movement = 32;
	protected boolean Busy = false;
	private double startXPos;
	private double startYPos;
	
	public Player(String ImageLink, double size, double xPos, double yPos) {
		super(ImageLink, size);
		
		this.startXPos = xPos;
		
		this.startYPos = yPos;
		
		RestoreDefaults();
		
		setOnKeyPressed( getKeyPressedHandler() );
	}

	@Override
	public void HandleOutOfBoundsEvent() {
		System.out.println(getY());
		if (getY() > 64) {
			RestoreDefaults();
		}
		
		if (getX() < 0) {
			moveX( movement * 2);
		}
		
		else if (getX() >= 600 - size) {
			moveX( -movement * 2);
		}
	}

	@Override
	public String getActorClassName() {
		return "Player";
	}
	
	public void RestoreDefaults(){
		
		Busy = false;
		
		setImage(ActorImage);
		
		setX(startXPos);
		
		setY(startYPos);

		return;
	}
	
	public abstract EventHandler<KeyEvent> getKeyPressedHandler();
	
}
