package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public abstract class Actor extends ImageView{
	protected double size;
	protected Image ActorImage;
	
	public Actor(String ImageLink, double size, double xPos, double yPos) {
		this(ImageLink, size);
		setX(xPos);
		setY(yPos);
	}
	
	public Actor(String ImageLink, double size) {
		ActorImage = new Image(ImageLink, size, size, true, true);
		this.size = size;
		setImage(ActorImage);
	}
	
	public Actor() {}

    public World getWorld() {
    	Node node = this;
    	do {
    		node = node.getParent();
    	}while(!(node instanceof World));
        return (World) node;
    }

    public List<Actor> getIntersectingObjects(){
        ArrayList<Actor> someArray = new ArrayList<Actor>();
        for (Actor actor: getWorld().getActorSet()) {
        	
        	final boolean intersects = this.localToScene(this.getBoundsInLocal()).intersects(actor.localToScene(actor.getBoundsInLocal()));
        	
            if (actor != this && intersects) {
                someArray.add(actor);
            }
        }
        return someArray;
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
