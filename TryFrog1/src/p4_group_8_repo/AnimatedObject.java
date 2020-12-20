package p4_group_8_repo;

import java.util.List;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;
/**
 * Base interface to describe animated objects
 * @author hfygk1
 *
 */
public interface AnimatedObject {
	/**
	 * Animates an object that has an ImageView 
	 * @param images list of slides for animation
	 * @param milliseconds duration of each slide
	 * @return returns animation 
	 */
	public default Transition animate(List<Image> images, int milliseconds) {
		Transition animation = new Transition() {
			{
		        setCycleDuration(Duration.millis(milliseconds)); // total time for animation
		    }

		    @Override
		    protected void interpolate(double fraction) {
		        final int animationSlideIndex = (int) (fraction * (images.size() - 1) );
		        setImage(images.get(animationSlideIndex)); 
		    }
		};
		return animation;
	}
	
	public void setImage(Image image);
	
	public void stopAnimation();
	
	public void continueAnimation();
}
