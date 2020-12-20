package p4_group_8_repo;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;

import java.util.List;

/**
 * This class defines turtles.
 * @author hfygk1
 *
 */
public class Turtle extends MovingObstacle implements AnimatedObject{
	Animation animationHandle;
	public Turtle(String imageLink, double size, double speed) {
		
		super(imageLink, size, speed);
		//Turtles are in an infinite animation cycle from their creation, to game end
		InitAnimation();
		
	}
	
	/**
	 * setting animation handle, that is used to control animation
	 * @param animation infinite animation ,that has to be saved to a handle
	 */
	public void setAnimationHandle(Animation animation) {
		animationHandle = animation;
	}
	
	
	/*
	 * This method initializes animation of the turtle
	 */
	public void InitAnimation() {
		
		final int milliseconds = 3000;
		
		final Image TurtleFirstSlide = new Image("file:src/p4_group_8_repo/TurtleAnimation1.png", size, size, true, true);
		
		final Image TurtleSecondSlide = ActorImage;
		
		final Image TurtleThirdSlide = new Image("file:src/p4_group_8_repo/TurtleAnimation3.png", size, size, true, true);
		
		List<Image> images = new ArrayList<> ();
		
		images.add(TurtleFirstSlide);
		
		images.add(TurtleSecondSlide);
		
		images.add(TurtleThirdSlide);
		
		PlayAnimation(images, milliseconds);
		
	}
	
	/**
	 * This method executes animation
	 * @param images Slides for animations
	 * @param milliseconds duration of each animation slide in milliseconds
	 */
	public void PlayAnimation(List<Image> images, int milliseconds) {
		
		Transition defaultAnimation = animate(images, milliseconds);
		
		Transition pause = new PauseTransition(Duration.millis(milliseconds));
		
		SequentialTransition animation = new SequentialTransition(defaultAnimation, pause);
		
		setAnimationHandle(animation);
		
		animation.setCycleCount(Transition.INDEFINITE);
		
		animation.play();
		
	}
	
	@Override
	public void stopAnimation() {
		animationHandle.pause();
	}
	
	@Override
	public void continueAnimation() {
		animationHandle.play();
	}
	
	@Override
	public String getActorClassName() {
		
		return "Turtle";
		
	}
	
}
