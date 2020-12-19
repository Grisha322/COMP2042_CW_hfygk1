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



public class Frogger extends Player {
	
	public Frogger(String imageLink, double size, double startXPos, double startYPos, List<Actor> lifes) {
		
		super(imageLink, size, startXPos, startYPos, lifes);	
		
	}
	
	@Override
	public void act() {
		
		HandleOutOfBoundsEvent();
		
		HandleInteractions();
		
	}
	
	public void HandleInteractions() {
		List<Actor> actors = getIntersectingObjects();
		
		final boolean ReachedWater = getY() < waterPoint;
		
		final boolean noInteractions = actors.isEmpty();
		
		if(ReachedWater && noInteractions) {
			handleDeath("Waterdeath");
			return;
		}
		
		for(Actor actor : actors) {
			HandleInteraction(actor);
		}
	}
	
	public void stopAnimation() {}
	
	public void continueAnimation() {}
	
	public void HandleInteraction(Actor actor) {
		final String actorName = actor.getActorClassName();
		
		final boolean carDeath = actorName.equalsIgnoreCase("Car");
		
		final boolean waterDeath = actorName.equalsIgnoreCase("WetTurtle") && ( (WetTurtle) actor ).isSunk();
		
		final boolean finalReached = actorName.equalsIgnoreCase("Final");
		
		if(carDeath) {
			handleDeath("Waterdeath");
			return;
		}
		else if(waterDeath){
			handleDeath("Cardeath");
			return;
		}
		else if(finalReached) {
			HandleFinal( (Final) actor );
			return;
		}

		if(actor instanceof MovingObstacle) {
			RideObstacle( (MovingObstacle) actor );
		}
	}
	
	public void RideObstacle(MovingObstacle obstacle) {
		moveX(obstacle.getSpeed());
	}
	
	public List<Image> getCarDeathSlides() {
		final Image carDeathFirstSlide = new Image("file:src/p4_group_8_repo/cardeath1.png", size, size, true, true);
		
		final Image carDeathSecondSlide = new Image("file:src/p4_group_8_repo/cardeath2.png", size, size, true, true);
		
		final Image carDeathThirdSlide = new Image("file:src/p4_group_8_repo/cardeath3.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(carDeathFirstSlide);
		
		images.add(carDeathSecondSlide);
		
		images.add(carDeathThirdSlide);
		
		return images;
		
	}
	
	public List<Image> getWaterDeathSlides() {
		
		final Image waterDeathFirstSlide = new Image("file:src/p4_group_8_repo/waterdeath1.png", size,size , true, true);

		final Image waterDeathSecondSlide = new Image("file:src/p4_group_8_repo/waterdeath2.png", size,size , true, true);

		final Image waterDeathThirdSlide = new Image("file:src/p4_group_8_repo/waterdeath3.png", size,size , true, true);

		final Image waterDeathFourthSlide = new Image("file:src/p4_group_8_repo/waterdeath4.png", size,size , true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(waterDeathFirstSlide);
		
		images.add(waterDeathSecondSlide);
		
		images.add(waterDeathThirdSlide);
		
		images.add(waterDeathFourthSlide);
		
		return images;
		
	}
	
	@Override
	public EventHandler<KeyEvent> getKeyPressedHandler() {
		EventHandler<KeyEvent> KeyPressedHandler = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				final int milliseconds = 50;
				if(dead || moving)
					return;
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
		};
		
		return KeyPressedHandler;
	}
	
	public void MoveUp(int milliseconds) {
		
		moveY(-movement);
		
		final boolean passedCheckPoint = getY() < currentCheckpoint;
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerUpJump.png", size, size, true, true);

		Image moveUpSecondSlide = ActorImage;
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		MovementAnimationPlay(images, milliseconds, 0, -movement);
		
		if (passedCheckPoint) {
			
			addPoints(10);
			
			currentCheckpoint = getY();
			
		}
		
	}
	
	public void MoveDown(int milliseconds) {
		
		moveY(movement);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerDownJump.png", size, size, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerDown.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		MovementAnimationPlay(images, milliseconds, 0, movement);
		
	}
	
	public void MoveLeft(int milliseconds) {
	
		moveX(-movement);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", size, size, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerLeft.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		MovementAnimationPlay(images, milliseconds, -movement, 0);
		
	}
	
	public void MoveRight(int milliseconds) {
		
		moveX(movement);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerRightJump.png", size, size, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerRight.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		MovementAnimationPlay(images, milliseconds, movement, 0);
		
	}
	
	public void MovementAnimationPlay(List<Image> images, int milliseconds, double moveX, double moveY) {
		moving = true;
		
		Transition MovementAnimation = animate(images, milliseconds);
		
		MovementAnimation.setOnFinished(event -> move(moveX, moveY));
		
		Transition PauseAfterAnimation = new PauseTransition(Duration.millis(milliseconds));
		
		SequentialTransition animation = new SequentialTransition(MovementAnimation, PauseAfterAnimation);
		
		animation.setOnFinished(event -> moving = false);
		
		animation.play();
	}

	@Override
	public String getActorClassName() {
		
		return "Animal";
		
	}

	@Override
	public List<Image> getDeathSlides(String deathType) {
		final boolean waterDeath = deathType.equalsIgnoreCase("Waterdeath");
		final boolean carDeath = deathType.equalsIgnoreCase("Cardeath");
		List<Image> slides = null;
		if(waterDeath) {
			slides = getWaterDeathSlides();
		}
		else if(carDeath) {
			slides = getCarDeathSlides();
		}
		return slides;
	}
}
