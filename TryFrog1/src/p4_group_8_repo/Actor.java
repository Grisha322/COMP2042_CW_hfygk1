package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for actors.
 * @author hfygk1
 *
 */
public abstract class Actor extends ImageView{
	protected double size;
	protected Image ActorImage;
	
	/**
	 * Construct an instance with an Image and size 
	 * @param ImageLink An address location of an image
	 * @param size Size of the ImageView
	 * @throws IllegalArgumentException if ImageLink is null 
	 */
	public Actor(String ImageLink, double size) throws IllegalArgumentException{
		if(ImageLink == null) 
			throw new IllegalArgumentException("ImageLink must be not null");
		ActorImage = new Image(ImageLink, size, size, true, true);
		this.size = size;
		setImage(ActorImage);
	}
	
	public Actor() {}
	
	/**
	 * Access Actor Image
	 * @return Instance of Image that is set as Actor Image
	 */
	public Image getActorImage() {
		return ActorImage;
	}

	/**
	 * Set a new Default Actor Image and change to it
	 * @param actorImage Instance of Image
	 * @throws IllegalArgumentException if actorImage is null
	 */
	public void setActorImage(Image actorImage) throws  IllegalArgumentException{
		if(actorImage == null)
			throw new IllegalArgumentException("Method setActorImage expects not null parameter");
		ActorImage = actorImage;
		setImage(ActorImage);
	}
	
	/**
	 * Access the size of an Actor
	 * @return value of the size of Actor
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * Accessing main controller of the game
	 * @return singleton Game object
	 */
    public Game getGame() {
    	return Game.getInstance();
    }
    
    /**
     * Checking for intersecting Actors
     * @return List of Actors that intersect with the caller
     */
    public List<Actor> getIntersectingObjects(){
        ArrayList<Actor> someArray = new ArrayList<Actor>();
        for (Actor actor: getGame(). getGameSpaceActorSet()) {
        	//check for intersection in terms of scene coordinates
        	final boolean intersects = this.localToScene(this.getBoundsInLocal()).intersects(actor.localToScene(actor.getBoundsInLocal()));
        	
            if (actor != this && intersects) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public abstract void act();
    
    public abstract String getActorClassName();
}
