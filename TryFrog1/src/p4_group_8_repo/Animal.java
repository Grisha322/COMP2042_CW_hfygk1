package p4_group_8_repo;

import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;


public class Animal extends MovingActor {
	int points = 0;
	int end = 0;
	boolean Busy = false;
	private double startXPos;
	private double startYPos;
	private final double movement = 13.3333333*2;
	private final double movementX = 10.666666*2;
	boolean changeScore = false;
	double checkPoint = 800;
	
	public Animal(String imageLink, double size, double startXPos, double startYPos) {
		
		super(imageLink, size, startXPos, startYPos);
		
		this.startXPos = startXPos;
		
		this.startYPos = startYPos;
		
		setOnKeyPressed( getKeyPressedHandler() );	
		
	}
	
	@Override
	public void act(long now) {
		HandleOutOfBoundsEvent();
		
		HandleInteractions();
	}
	
	public void HandleInteractions() {
		List<Actor> actors = getIntersectingObjects(Actor.class);
		
		final boolean ReachedWater = getY() < 413;
		
		final boolean noInteractions = actors.isEmpty();
		
		if(ReachedWater && noInteractions) {
			waterDeathAnimation();
			return;
		}
		
		for(Actor actor : actors) {
			HandleInteraction(actor);
		}
	}
	
	
	public void HandleInteraction(Actor actor) {
		final String actorName = actor.getActorClassName();
		
		final boolean carDeath = actorName.equalsIgnoreCase("Car");
		
		final boolean waterDeath = actorName.equalsIgnoreCase("WetTurtle") && ( (WetTurtle) actor ).isSunk();
		
		final boolean finalReached = actorName.equalsIgnoreCase("Final");
		
		if(carDeath) {
			carDeathAnimation();
			return;
		}
		else if(waterDeath){
			waterDeathAnimation();
			return;
		}
		else if(finalReached) {
			HandleFinal( (Final) actor );
			return;
		}

		if(actor instanceof Obstacle) {
			RideObstacle( (Obstacle) actor );
		}
	}
	
	public void RideObstacle(Obstacle obstacle) {
		
		move( obstacle.getSpeed(), 0 );
		
	}
	
	public void HandleFinal(Final actorFinal) {
		if(actorFinal.isActivated()) {
			actorFinal.deactivate();
			end--;
			points -= 50;
		}
		else {
			actorFinal.activate();
			end++;
			points += 50;
			checkPoint = 800;
		}
		
		RestoreDefaults();
	}
	
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void carDeathAnimation() {
		
		Busy = true;
		
		final Image carDeathFirstSlide = new Image("file:src/p4_group_8_repo/cardeath1.png", size, size, true, true);
		
		final Image carDeathSecondSlide = new Image("file:src/p4_group_8_repo/cardeath2.png", size, size, true, true);
		
		final Image carDeathThirdSlide = new Image("file:src/p4_group_8_repo/cardeath3.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(carDeathFirstSlide);
		
		images.add(carDeathSecondSlide);
		
		images.add(carDeathThirdSlide);
		
		images.add(ActorImage);
		
		playDeathAnimation(images);
		
	}
	
	public void waterDeathAnimation() {
		
		Busy = true;

		final Image waterDeathFirstSlide = new Image("file:src/p4_group_8_repo/waterdeath1.png", size,size , true, true);

		final Image waterDeathSecondSlide = new Image("file:src/p4_group_8_repo/waterdeath2.png", size,size , true, true);

		final Image waterDeathThirdSlide = new Image("file:src/p4_group_8_repo/waterdeath3.png", size,size , true, true);

		final Image waterDeathFourthSlide = new Image("file:src/p4_group_8_repo/waterdeath4.png", size,size , true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(waterDeathFirstSlide);
		
		images.add(waterDeathSecondSlide);
		
		images.add(waterDeathThirdSlide);
		
		images.add(waterDeathFourthSlide);
		
		images.add(ActorImage);
		
		playDeathAnimation(images);
		
	}
	
	public void playDeathAnimation(List<Image> images) {
		
		final int milliseconds = 300;
		
		Transition deathAnimation = animate(images, milliseconds);
		
		Transition pauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds * 3));
		
		deathAnimation.play();
		
		SequentialTransition animation = new SequentialTransition(pauseAfterAnimation);

		animation.setOnFinished(event -> RestoreDefaults());
		
		animation.play();
		
		substractPoints();
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	@Override
	public void HandleOutOfBoundsEvent() {
		
		if (getY()<0 || getY()>734) {
			RestoreDefaults();
		}
		
		if (getX() < 0) {
			move( movement * 2, 0 );
		}
		
		else if (getX() > 600) {
			move( -movement * 2, 0 );
		}
	}
	
	public void RestoreDefaults(){
		
		Busy = false;
		
		setImage(ActorImage);
		
		setX(startXPos);
		
		setY(startYPos);

		return;
	}
	
	public void MoveUp(int milliseconds) {
		final boolean passedCheckPoint = getY() < checkPoint;
		
		move(0, -movement);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerUpJump.png", size, size, true, true);

		Image moveUpSecondSlide = ActorImage;
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		MovementAnimationPlay(images, milliseconds, 0, -movement);
		
		if (passedCheckPoint) {
			changeScore = true;
			checkPoint = getY();
			points+=10;
		}
		
	}
	
	public void MoveDown(int milliseconds) {
		
		move(0, movement);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerDownJump.png", size, size, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerDown.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		MovementAnimationPlay(images, milliseconds, 0, movement);
		
	}
	
	public void MoveLeft(int milliseconds) {
	
		move(-movementX, 0);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", size, size, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerLeft.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		MovementAnimationPlay(images, milliseconds, -movementX, 0);
		
	}
	
	public void MoveRight(int milliseconds) {
		
		move(movementX, 0);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerRightJump.png", size, size, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerRight.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		MovementAnimationPlay(images, milliseconds, movementX, 0);
		
	}
	
	public void MovementAnimationPlay(List<Image> images, int milliseconds, double moveX, double moveY) {
		
		Transition MovementAnimation = animate(images, milliseconds);
		
		MovementAnimation.setOnFinished(event -> move(moveX, moveY));
		
		Transition PauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds));
		
		SequentialTransition animation = new SequentialTransition(MovementAnimation, PauseAfterAnimation);
		
		animation.setOnFinished(event -> { Busy = false; });
		
		animation.play();
	}
	
	public EventHandler<KeyEvent> getKeyPressedHandler() {
		EventHandler<KeyEvent> KeyPressedHandler = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (!Busy) {
					
					final int milliseconds = 100;
					
					Busy = true;
					
					if (event.getCode() == KeyCode.W) {	 
						
		                MoveUp(milliseconds);
		                
		            }
		            else if (event.getCode() == KeyCode.A) {
		            	
		            	 MoveLeft(milliseconds);
		            	 
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 
		            	 MoveDown(milliseconds);
		            }
		            else if (event.getCode() == KeyCode.D) {
		            	
		            	 MoveRight(milliseconds);
		            	 
		            }
				}
			}
		};
		
		return KeyPressedHandler;
	}

	public void substractPoints(){
		if (points>50) {
			points-=50;
			changeScore = true;
		}
	}
	
	@Override
	public String getActorClassName() {
		
		return "Animal";
		
	}
}
