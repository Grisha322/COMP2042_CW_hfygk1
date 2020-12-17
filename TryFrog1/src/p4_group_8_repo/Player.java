package p4_group_8_repo;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public abstract class Player extends MovingActor {
	
	protected final double movement = 33;
	protected final double movementX = 22;
	protected boolean Busy = false;
	private double startXPos;
	private double startYPos;
	
	public Player(String ImageLink, double size, double xPos, double yPos) {
		super(ImageLink, size, xPos, yPos);
		
		this.startXPos = xPos;
		
		this.startYPos = yPos;
		
		setOnKeyPressed( getKeyPressedHandler() );
	}

	@Override
	public void HandleOutOfBoundsEvent() {
		if (getY() >= 60-size) {
			RestoreDefaults();
		}
		
		if (getX() < 0) {
			move( movement * 2, 0 );
		}
		
		else if (getX() >= 400 - size) {
			move( -movement * 2, 0 );
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
