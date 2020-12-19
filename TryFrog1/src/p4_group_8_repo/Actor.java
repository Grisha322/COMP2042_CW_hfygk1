package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

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

    public Game getGame() {
    	return Game.getInstance();
    }

    public List<Actor> getIntersectingObjects(){
        ArrayList<Actor> someArray = new ArrayList<Actor>();
        for (Actor actor: getGame(). getGameSpaceActorSet()) {
        	
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
