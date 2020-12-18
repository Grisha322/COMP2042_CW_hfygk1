package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	private AnimationTimer timer;
	private MyStage window;
	private List<Actor> players;
	private List<Actor> score;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
		
		primaryStage.setTitle("Frogger");
		
	    window = new MyStage();
	    
	    window.getChildren().add(root);
	    
	    Scene scene  = new Scene(window,600,900);
	    
	    window.setActorSet();
	    
		window.start();
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		//start(); 
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	for(Actor Player:players) {
	            	if (( (Animal) Player).scoreChanged()) {
	            		setNumber(( (Animal) Player).getPoints());
	            	}
	            	if (( (Animal) Player).getStop()) {
	            		System.out.print("STOPP:");
	            		window.stopMusic();
	            		stop();
	            		window.stop();
	            		Alert alert = new Alert(AlertType.INFORMATION);
	            		alert.setTitle("You Have Won The Game!");
	            		alert.setHeaderText("Your High Score: "+( (Animal) Player).getPoints()+"!");
	            		alert.setContentText("Highest Possible Score: 800");
	            		alert.show();
	            	}
            	}
            }
        };
    }
	public void start() {
		window.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int points) {
    	for(Actor digit:score) {
    		final int number = points % 10;
    		
    		((Digit) digit).setDigit(number);
    		
    		points /= 10;
    	}
    }
}
