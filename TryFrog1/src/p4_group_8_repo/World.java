package p4_group_8_repo;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public abstract class World extends Pane {
    private AnimationTimer timer;
    private List<Actor> ActorSet;
    public World() {
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							for (Actor anActor: ActorSet) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							for (Actor anActor: ActorSet) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }
    
    public void setActorSet() {
    	ActorSet = getActors(this);
    }
    
    public List<Actor> getActorSet(){
    	return ActorSet;
    }
    
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (Actor anActor: ActorSet) {
                	anActor.act();
                }
      
            }
        };
    }

    public void start() {
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void add(ImageView actor) {
        getChildren().add(actor);
    }

    public void remove(ImageView actor) {
        getChildren().remove(actor);
    }

    public List<Actor> getActors(Pane pane) {
        ArrayList<Actor> someArray = new ArrayList<Actor>();
        for (Node node: pane.getChildren()) {
        	if(node instanceof Pane) {
        		someArray.addAll(getActors((Pane)node));
        	}
        	else if (node instanceof Actor) {
                someArray.add((Actor)node);
            }
        }
        return someArray;
    }

}
