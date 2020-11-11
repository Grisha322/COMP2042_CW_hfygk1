package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public abstract class Actor extends ImageView{
	protected double size;
	protected Image ActorImage;
	
	public Actor(String ImageLink, double size, double xPos, double yPos) {
		ActorImage = new Image(ImageLink, size, size, true, true);
		this.size = size;
		setX(xPos);
		setY(yPos);
		setImage(ActorImage);
	}
	
	public Actor() {}

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }
    
    public Transition animate(List<Image> images, int milliseconds) {
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
	
    public abstract void act();
    
    public abstract String getActorClassName();
}
