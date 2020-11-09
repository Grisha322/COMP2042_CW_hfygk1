package p4_group_8_repo;

import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Duration;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.animation.Transition;


public class Animal extends Actor {
	Image ActorImage;
	int points = 0;
	int end = 0;
	boolean Busy = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	
	public Animal(String imageLink) {
		
		ActorImage = new Image(imageLink, imgSize, imgSize, true, true);
		
		RestoreDefaults(); 
		
		setOnKeyPressed( getKeyPressedHandler() );	
		
		setOnKeyReleased(event -> {
			Busy = false;
		});
		
	}
	
	@Override
	public void act(long now) {
		HandleOutOfBoundsEvent();
		if(Busy) {
			return;
		}
		if (carDeath) {
			carDeathAnimation();
		}
		if (waterDeath) {
			waterDeathAnimation();
		}
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			RestoreDefaults();
		}
		else if (getY()<413){
			waterDeath = true;
			//moveToDefaultLocation
		}
	}
	
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void carDeathAnimation() {
		
		Busy = true;
		
		final int milliseconds = 300;

		final Image carDeathFirstSlide = new Image("file:src/p4_group_8_repo/cardeath1.png", imgSize, imgSize, true, true);
		
		final Image carDeathSecondSlide = new Image("file:src/p4_group_8_repo/cardeath2.png", imgSize, imgSize, true, true);
		
		final Image carDeathThirdSlide = new Image("file:src/p4_group_8_repo/cardeath3.png", imgSize, imgSize, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(carDeathFirstSlide);
		
		images.add(carDeathSecondSlide);
		
		images.add(carDeathThirdSlide);
		
		animate(images, milliseconds);
		
		carDeath = false;
		
		substractPoints();
		
	}
	
	public void waterDeathAnimation() {
		Busy = true;
		
		final int milliseconds = 300;

		final Image waterDeathFirstSlide = new Image("file:src/p4_group_8_repo/waterdeath1.png", imgSize,imgSize , true, true);

		final Image waterDeathSecondSlide = new Image("file:src/p4_group_8_repo/waterdeath2.png", imgSize,imgSize , true, true);

		final Image waterDeathThirdSlide = new Image("file:src/p4_group_8_repo/waterdeath3.png", imgSize,imgSize , true, true);

		final Image waterDeathFourthSlide = new Image("file:src/p4_group_8_repo/waterdeath4.png", imgSize,imgSize , true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(waterDeathFirstSlide);
		
		images.add(waterDeathSecondSlide);
		
		images.add(waterDeathThirdSlide);
		
		images.add(waterDeathFourthSlide);
		
		animate(images, milliseconds);
		
		waterDeath = false;
		
		substractPoints();
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	public void HandleOutOfBoundsEvent() {
		if (getY()<0 || getY()>734) {
			RestoreDefaults();
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		else if (getX()>600) {
			move(-movement*2, 0);
		}
	}
	
	public void RestoreDefaults(){
		
		final double defaultX = 300;
		
		final double defaultY = 679.8 + movement;
		
		Busy = false;
		
		setImage(ActorImage);
		
		setX(defaultX);
		
		setY(defaultY);

		return;
	}
	
	public void animate(List<Image> images, int milliseconds) {
		Transition animation = new Transition() {
			{
		        setCycleDuration(Duration.millis(milliseconds)); // total time for animation
		    }

		    @Override
		    protected void interpolate(double fraction) {
		        final int animationSlideIndex = (int) (fraction * (images.size() - 1 ) );
		        setImage(images.get(animationSlideIndex)); 
		    }
		};
		animation.play();
		
		if(carDeath || waterDeath)
			animation.setOnFinished(event -> RestoreDefaults());
	}
	
	public void MoveUp(int milliseconds) {
		
		move(0, -movement);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerUpJump.png", imgSize, imgSize, true, true);

		Image moveUpSecondSlide = ActorImage;
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		animate(images, milliseconds);
		
		move(0, -movement);
		
		if (getY() < w) {
			changeScore = true;
			w = getY();
			points+=10;
		}
		
	}
	
	public void MoveDown(int milliseconds) {
		
		move(0, movement);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerDownJump.png", imgSize, imgSize, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerDown.png", imgSize, imgSize, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		animate(images, milliseconds);
		
		move(0, movement);
		
	}
	
	public void MoveLeft(int milliseconds) {
	
		move(-movementX, 0);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", imgSize, imgSize, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerLeft.png", imgSize, imgSize, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		animate(images, milliseconds);
		
		move(-movementX, 0);
		
	}
	
	public void MoveRight(int milliseconds) {
		
		move(movementX, 0);
		
		Image moveUpFirstSlide = new Image("file:src/p4_group_8_repo/froggerRightJump.png", imgSize, imgSize, true, true);

		Image moveUpSecondSlide = new Image("file:src/p4_group_8_repo/froggerRight.png", imgSize, imgSize, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(moveUpFirstSlide);
		
		images.add(moveUpSecondSlide);
		
		animate(images, milliseconds);
		
		move(movementX, 0);
		
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
}
