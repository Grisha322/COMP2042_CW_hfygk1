package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * This class describes player interface
 * @author hfygk1
 *
 */
public abstract class Player extends MovingActor implements AnimatedObject{
	
	List<Life> lifes = new ArrayList<Life>();
	protected final double movement = 32;
	private final double checkpoint = 0;
	protected boolean dead = false;
	protected boolean moving = false;
	protected double startXPos;
	protected double startYPos;
	protected int totalPoints = 0;
	protected boolean scoreChanged = false;
	protected double currentCheckpoint;
	protected final double waterPoint = -320;
	
	public Player(String ImageLink, double size, double xPos, double yPos, List<Actor> lifes) {
		super(ImageLink, size);
		
		this.startXPos = xPos;
		
		this.startYPos = yPos;
		
		RestoreDefaults();
		
		setOnKeyPressed( getKeyPressedHandler() );
		
		setLifes(lifes);
		
		currentCheckpoint = checkpoint;
	}
	
	/**
	 * Handles death event
	 * @param deathType death type of the player
	 */
	public void handleDeath(String deathType) {
		List<Image> slides = getDeathSlides(deathType);
		substractPoints(50);
		removeLife();
		dead = true;
		playDeathAnimation(slides);
	}
	
	/**
	 * This method is used to play death animation
	 * @param images animation slides
	 */
	public void playDeathAnimation(List<Image> images) {
		if(lifesLeft() > 0)
			getGame().pauseGame();
		
		final int milliseconds = 500;
		
		Transition deathAnimation = animate(images, milliseconds);
		
		Transition pauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds));
		
		SequentialTransition animation = new SequentialTransition(deathAnimation, pauseAfterAnimation);

		animation.setOnFinished(event -> {if(lifesLeft() > 0) { getGame().continueGame(); RestoreDefaults(); }});
		
		animation.play();
		
	}
	
	/**
	 * Accessing lifes field
	 * @param lifes list of Life instances
	 */
	public void setLifes(List<Actor> lifes) {
		for(Actor life: lifes) {
			final int index = 0;
			
			this.lifes.add(index, (Life) life);
		}
	}
	
	/**
	 * Makes on of the lifes inactive
	 */
	public void removeLife() {
		for(Life life: lifes) {
			if(life.isActive()) {
				life.removeLife();
				return;
			}
		}
	}
	
	/**
	 * This method check for the amount of active lifes left
	 * @return returns number of active lifes left
	 */
	public int lifesLeft() {
		int counter = 0;
		for(Life life: lifes) {
			if(life.isActive()) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * This method is used to deduct points
	 * @param points to be deducted
	 */
	public void substractPoints(int points){
		totalPoints = (totalPoints <= points ? 0 : (totalPoints - points));
		scoreChanged = true;
	}
	
	/**
	 * Accessing total score
	 * @return total score of the player
	 */
	public int getPoints() {
		return totalPoints;
	}
	
	/**
	 * This method is used to add points
	 * @param points to be added
	 */
	public void addPoints(int points) {
		totalPoints += points;
		scoreChanged = true;
	}
	
	/**
	 * Accessing scoreChanged field
	 * @return scoreChanged
	 */
	public boolean scoreChanged() {
		if (scoreChanged) {
			scoreChanged = false;
			return true;
		}
		return false;
		
	}
	
	/**
	 * Handle final reaching event
	 * @param actorFinal instance of a Final that has been reached
	 */
	public void HandleFinal(Final actorFinal) {
		if(actorFinal.isActivated()) {
			actorFinal.deactivate();
			substractPoints(50);
		}
		else {
			actorFinal.activate();
			addPoints(50);
		}
		currentCheckpoint = checkpoint;
		RestoreDefaults();
	}
	
	/**
	 * Overriding handleoutofbounds event of the MovingActor superclass
	 */
	@Override
	public void HandleOutOfBoundsEvent() {
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
	
	/**
	 * Setting position image and states to default
	 */
	public void RestoreDefaults(){
		setImage(ActorImage);
		
		setX(startXPos);
		
		setY(startYPos);
		
		dead = false;

		moving = false;
		
		return;
	}
	
	public abstract EventHandler<KeyEvent> getKeyPressedHandler();
	
	public abstract List<Image> getDeathSlides(String deathType);
}
