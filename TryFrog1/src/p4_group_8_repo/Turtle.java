package p4_group_8_repo;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;

import java.util.List;

public class Turtle extends Obstacle{
	
	public Turtle(String imageLink, double size, double xpos, double ypos, double speed) {
		
		super(imageLink, size, xpos, ypos, speed);
		
		InitAnimation();
		
	}
	
	public void InitAnimation() {
		
		final int milliseconds = 1000;
		
		final Image TurtleFirstSlide = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", size, size, true, true);
		
		final Image TurtleSecondSlide = ActorImage;
		
		final Image TurtleThirdSlide = new Image("file:src/p4_group_8_repo/TurtleAnimation3.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(TurtleFirstSlide);
		
		images.add(TurtleSecondSlide);
		
		images.add(TurtleThirdSlide);
		
		PlayAnimation(images, milliseconds);
		
	}
	
	public void PlayAnimation(List<Image> images, int milliseconds) {
		
		Transition defaultAnimation = animate(images, milliseconds);
		
		Transition pause = new PauseTransition(Duration.millis(milliseconds));
		
		SequentialTransition animation = new SequentialTransition(defaultAnimation, pause);
		
		animation.setCycleCount(Transition.INDEFINITE);
		
		animation.play();
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "Turtle";
		
	}
}
