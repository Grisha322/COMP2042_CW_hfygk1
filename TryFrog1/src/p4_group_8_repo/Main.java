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
	    
	    Scene scene  = new Scene(window,400,700);
		
	    //AddObstacles();
	    
	    //AddPlayer();
	    
	    //AddStaticActors();
	    
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
	            	if (( (Animal) Player).changeScore()) {
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
    
    private void AddObstacles() {
    	ActorGroupAdder GroupAdder = new ActorGroupAdder("ObstacleFactory");
    	
    	AddLogs(GroupAdder);
    	
    	AddTurtles(GroupAdder);
    	
    	AddCars(GroupAdder);
    	
    	AddTracks(GroupAdder);
    }
    
    private void AddPlayer() {
    	ActorGroupAdder GroupAdder = new ActorGroupAdder("PlayerFactory");
    	
    	GroupAdder.setStartXPos(300);
    	
    	GroupAdder.setYPos(706.4666);
    	
    	GroupAdder.setAmount(1);
    	
    	AddAnimals(GroupAdder);
    }
    
    private void AddStaticActors() {
    	ActorGroupAdder GroupAdder = new ActorGroupAdder("StaticFactory");
    	
    	GroupAdder.setActorType("Final");
    	
    	GroupAdder.setAmount(5);
    	
    	GroupAdder.setStartXPos(13);
    	
    	GroupAdder.setYPos(96);
    	
    	AddFinals(GroupAdder);
    	
    	GroupAdder.setAmount(3);
    	
    	GroupAdder.setActorType("Digit");
    	
    	GroupAdder.setStartXPos(360);
    	
    	GroupAdder.setYPos(25);
    	
    	AddDigits(GroupAdder);
    }
    
    private void AddLogs(ActorGroupAdder GroupAdder) {
    	GroupAdder.setActorType("Log");
    	
    	GroupAdder.setAmount(3);
    	
    	GroupAdder.setStartXPos(0);
    	
    	GroupAdder.setYPos(166);
    	
    	GroupAdder.setSpeed(0.75);
    	
    	AddSmallLogs(GroupAdder);
    	
    	GroupAdder.setAmount(3);
    	
    	GroupAdder.setStartXPos(50);
    	
    	GroupAdder.setYPos(329);
    	
    	GroupAdder.setSpeed(0.75);
    	
    	AddSmallLogs(GroupAdder);
    	
    	GroupAdder.setAmount(2);
    	
    	GroupAdder.setStartXPos(0);
    	
    	GroupAdder.setYPos(276);
    	
    	GroupAdder.setSpeed(-2);
    	
    	AddBigLogs(GroupAdder);
    	
    }
    
    private void AddTurtles(ActorGroupAdder GroupAdder) {
    	GroupAdder.setActorType("Turtle");
    	
    	GroupAdder.setAmount(2);
    	
    	GroupAdder.setStartXPos(300);
    	
    	GroupAdder.setYPos(376);
    	
       	GroupAdder.setSpeed(-1);
    	
    	AddNormalTurtles(GroupAdder);
    	
    	GroupAdder.setActorType("WetTurtle");
    	
    	GroupAdder.setAmount(1);
    	
    	GroupAdder.setStartXPos(700);
    	
    	GroupAdder.setYPos(376);
    	
       	GroupAdder.setSpeed(-1);
    	
    	AddWetTurtles(GroupAdder);
    	
    	GroupAdder.setAmount(3);
    	
    	GroupAdder.setStartXPos(200);
    	
    	GroupAdder.setYPos(217);
    	
       	GroupAdder.setSpeed(-1);
    	
    	AddWetTurtles(GroupAdder);
    }
    
    private void AddCars(ActorGroupAdder GroupAdder) {
    	GroupAdder.setActorType("Car");
    	
    	GroupAdder.setAmount(4);
    	
    	GroupAdder.setYPos(597);
    	
    	GroupAdder.setStartXPos(100);
    	
    	GroupAdder.setSpeed(-1);
    	
    	AddNormalCars(GroupAdder);
		
    	GroupAdder.setAmount(1);
    	
    	GroupAdder.setStartXPos(500);
    	
    	GroupAdder.setYPos(490);
    	
    	GroupAdder.setSpeed(-5);
    	
    	AddNormalCars(GroupAdder);
    	
    }
    
    private void AddTracks(ActorGroupAdder GroupAdder) {
    	GroupAdder.setActorType("Car");
    	
    	GroupAdder.setAmount(3);
    	
    	GroupAdder.setStartXPos(0);
    	
    	GroupAdder.setYPos(649);
    	
    	GroupAdder.setSpeed(1);
    	
    	AddNormalTracks(GroupAdder);
    	
    	GroupAdder.setStartXPos(0);
    	
    	GroupAdder.setYPos(540);
    	
    	GroupAdder.setAmount(2);
    	
    	GroupAdder.setSpeed(1);
    	
    	AddBigTracks(GroupAdder);
    }
    
    private void AddSmallLogs(ActorGroupAdder GroupAdder) {
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/log3.png");
    	
    	GroupAdder.setShift(220);
    	
    	GroupAdder.setSize(150);
    	
    	GroupAdder.AddToWindow(window);
    	
    }
    
    private void AddBigLogs(ActorGroupAdder GroupAdder) {
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/logs.png");
    	
    	GroupAdder.setShift(400);
    	
    	GroupAdder.setSize(300);
    	
    	GroupAdder.AddToWindow(window);
    }
    
    private void AddNormalTurtles(ActorGroupAdder GroupAdder) {
    	
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/TurtleAnimation2.png");
    	
    	GroupAdder.setShift(200);
    	   	   	
    	GroupAdder.setSize(130);
    	
    	GroupAdder.AddToWindow(window);
    }
    
    private void AddWetTurtles(ActorGroupAdder GroupAdder) {
    	
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/TurtleAnimation1.png");
    	
    	GroupAdder.setShift(200);
   	   	
    	GroupAdder.setSize(130);
    	
    	GroupAdder.AddToWindow(window);
    	
    }
    
    private void AddNormalCars(ActorGroupAdder GroupAdder) {
		GroupAdder.setImageLink("file:src/p4_group_8_repo/car1Left.png");
    	
    	GroupAdder.setShift(150);
    	
    	GroupAdder.setSize(50);
    	
    	GroupAdder.AddToWindow(window);
    }
    
    private void AddNormalTracks(ActorGroupAdder GroupAdder) {
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/truck1Right.png");

    	GroupAdder.setShift(300);

    	GroupAdder.setSize(120);

    	GroupAdder.AddToWindow(window);
    }
    
    private void AddBigTracks(ActorGroupAdder GroupAdder) {
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/truck2Right.png");

    	GroupAdder.setShift(500);

    	GroupAdder.setSize(200);

    	GroupAdder.AddToWindow(window);
    }
    
    private void AddAnimals(ActorGroupAdder GroupAdder) {
    	GroupAdder.setActorType("Animal");
    	
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/froggerUp.png");
    	
    	GroupAdder.setShift(160);
    	
    	GroupAdder.setSize(40);
    	
    	players = GroupAdder.AddToWindow(window);
    }
    
    private void AddDigits(ActorGroupAdder GroupAdder) {
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/0.png");

    	GroupAdder.setShift(-30);

    	GroupAdder.setSize(30);

    	score = GroupAdder.AddToWindow(window);
    }
    
    private void AddFinals(ActorGroupAdder GroupAdder) {
    	GroupAdder.setImageLink("file:src/p4_group_8_repo/End.png");

    	GroupAdder.setShift(128.2);

    	GroupAdder.setSize(60);

    	GroupAdder.AddToWindow(window);
    }
}
