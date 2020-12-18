package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ActorGroupAdder {
	private double size;
	private double speed;
	private int amount;
	private String imageLink = "";
	private String ActorType =  "";
	private String ActorGroup;
	private double distanceBetweenActors = 0;
	
	public ActorGroupAdder() {}
	
	public ActorGroupAdder(String ActorGroup, String ActorType, String imageLink) {
		initiActorGroupAdder(ActorGroup, ActorType, imageLink);
	}
	
	public void initiActorGroupAdder(String ActorGroup, String ActorType, String imageLink) {
		setActorGroup(ActorGroup);
		setImageLink(imageLink);
		setActorType(ActorType);
		distanceBetweenActors = 0;
	}
	
	public void setActorGroup(String ActorGroup) {
		this.ActorGroup = ActorGroup;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	public void setActorType(String ActorType) {
		this.ActorType = ActorType;
	}
	
	public void setDistanceBetweenActors(double distanceBetweenActors) {
		this.distanceBetweenActors = distanceBetweenActors;
	}
	
	public List<Actor> AddToLine(Pane line) {
		List<Actor> actorsAdded = new ArrayList<>();
		
		ActorFactoryProducer factoryProducer = ActorFactoryProducer.getActorFactoryProducer();
		
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