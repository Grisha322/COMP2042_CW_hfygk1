package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class WetTurtle extends Turtle{
	private boolean sunk;
	
	public WetTurtle(String imageLink, double size, double xpos, double ypos, double speed) {
		
		super(imageLink, size, xpos, ypos, speed);
		
	}
	
	@Override
	public void InitAnimation() {
		
		final int milliseconds = 1500;
		
		final Image TurtleSunkFirstSlide = new Image("file:src/p4_group_8_repo/TurtleAnimation2Wet.png", size, size, true, true);
		
		final Image TurtleSunkSecondSlide = new Image("file:src/p4_group_8_repo/TurtleAnimation3Wet.png", size, size, true, true);
		
		final Image TurtleSunkThirdSlide = new Image("file:src/p4_group_8_repo/TurtleAnimation4Wet.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(TurtleSunkFirstSlide);
		
		images.add(TurtleSunkSecondSlide);
		
		images.add(TurtleSunkThirdSlide);
		
		PlayAnimation(images, milliseconds);
		
	}
	
	@Override
	public void PlayAnimation(List<Image> imagesForSunkAnimation, int milliseconds) {
		
		List<Image> imagesForDefaultAnimation = new ArrayList<> ();
		
		imagesForDefaultAnimation.add(ActorImage);
		
		Transition defaultAnimation = animate(imagesForDefaultAnimation, milliseconds);
		
		defaultAnimation.setOnFinished(event -> {sunk = true;});
		
		Transition sunkAnimation = animate(imagesForSunkAnimation, milliseconds);
		
		sunkAnimation.setOnFinished(event -> {sunk = false;});
		
		Transition pauseBeforeAnimationCycle = new PauseTransition(Duration.millis(milliseconds));
		
		SequentialTransition animation = new SequentialTransition(defaultAnimation, sunkAnimation, pauseBeforeAnimationCycle);
		
		animation.setCycleCount(SequentialTransition.INDEFINITE);
		
		animation.play();
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "WetTurtle";
		
	}
	
	public boolean isSunk() {
		return sunk;
	}
	
}
