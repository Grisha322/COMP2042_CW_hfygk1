package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
/**
 * Class wrapper for actor factory. Is used to add multiple actors at once to a pane and return a handle to it 
 * @author hfygk1
 *
 */
public class ActorGroupAdder {
	private double size;
	private double speed;
	private int amount;
	private String imageLink = "";
	private String ActorType =  "";
	private String ActorGroup;
	private double distanceBetweenActors;
	
	public ActorGroupAdder() {}
	
	/**
	 * Constructs an instance with actor group identifiers
	 * @param ActorGroup used to identify which actor factory needed
	 * @param ActorType used to identify which actor should a factory produce
	 * @param imageLink location of an image
	 */
	public ActorGroupAdder(String ActorGroup, String ActorType, String imageLink) throws IllegalArgumentException{
		if(ActorGroup == null || ActorType == null || imageLink == null)
			throw new IllegalArgumentException("Parameters must be not null");
		initiActorGroupAdder(ActorGroup, ActorType, imageLink);
	}

	/**
	 * Initializing and reinitializing same group actor adder
	 * @param ActorGroup used to identify which actor factory needed
	 * @param ActorType used to identify which actor should a factory produce
	 * @param imageLink location of an image
	 */
	public void initiActorGroupAdder(String ActorGroup, String ActorType, String imageLink) {
		setActorGroup(ActorGroup);
		setImageLink(imageLink);
		setActorType(ActorType);
		distanceBetweenActors = 0;
	}
	
	/**
	 * Setting ActorGroup field
	 * @param ActorGroup used to identify which actor factory needed
	 */
	public void setActorGroup(String ActorGroup) {
		this.ActorGroup = ActorGroup;
	}
	
	/**
	 * Setting amount of actors to be created in a current batch
	 * @param amount Amount of actors to be created
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * Setting speed parameter for each actor created in a current batch
	 * @param speed speed of actors
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * Setting size of each actor to be created in a current batch
	 * @param size an actor type
	 */
	public void setSize(double size) {
		this.size = size;
	}
	
	/**
	 * Setting imageLink field
	 * @param imageLink location of an image
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	/**
	 * Setting ActorType field
	 * @param ActorType used to identify which actor should a factory produce
	 */
	public void setActorType(String ActorType) {
		this.ActorType = ActorType;
	}
	
	/**
	 * Setting horizontal distance between actors
	 * @param distanceBetweenActors Distance between actors
	 */
	public void setDistanceBetweenActors(double distanceBetweenActors) {
		this.distanceBetweenActors = distanceBetweenActors;
	}
	
	
	/**
	 * Creates a batch of actors and adds them to a pane.
	 * @param line Pane that actors are going to be added to
	 * @return returns handle to actors added
	 */
	public List<Actor> AddToLine(Pane line) {
		List<Actor> actorsAdded = new ArrayList<>();
		
		ActorFactoryProducer factoryProducer = ActorFactoryProducer.getInstance();
		
		ActorFactory factory = factoryProducer.getActorFactory(ActorGroup);
		
		if(factory instanceof MovingObstalceFactory) {
			((MovingObstalceFactory) factory).setSpeed(speed);
		}
		
		for(int iterator = 0; iterator < amount; iterator++) {
    		
    		Actor actor = factory.getActor(ActorType, imageLink, size);
    		
    		actorsAdded.add(actor);
    		
    		line.getChildren().add((ImageView) actor);
    		
    		if(distanceBetweenActors != 0) {
    			actor.setX((size + distanceBetweenActors) * iterator);
    		}
    		
		}
		
		return actorsAdded;
	}
}