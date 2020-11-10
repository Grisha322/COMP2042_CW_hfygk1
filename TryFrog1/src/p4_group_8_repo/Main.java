package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();
	    Scene scene  = new Scene(background,600,800);
	    
		//Car Car = new Car("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Car Car1 = new Car("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Car Car2 = new Car("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);

		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/Screen Shot 2017-05-29 at 10.02.14 PM.png");
	    
		background.add(froggerback);
		
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 490, 329, 0.75));
		
		background.add(new Turtle("file:src/p4_group_8_repo/TurtleAnimation2.png", 130, 500, 376, -1));
		background.add(new Turtle("file:src/p4_group_8_repo/TurtleAnimation2.png", 130, 300, 376, -1));
		background.add(new WetTurtle("file:src/p4_group_8_repo/TurtleAnimation1.png", 130, 700, 376, -1));
		background.add(new WetTurtle("file:src/p4_group_8_repo/TurtleAnimation1.png", 130, 600, 217, -1));
		background.add(new WetTurtle("file:src/p4_group_8_repo/TurtleAnimation1.png", 130, 400, 217, -1));
		background.add(new WetTurtle("file:src/p4_group_8_repo/TurtleAnimation1.png", 130, 200, 217, -1));
		
		background.add(new Final("file:src/p4_group_8_repo/End.png", 60, 13, 96));
		background.add(new Final("file:src/p4_group_8_repo/End.png", 60, 141,96));
		background.add(new Final("file:src/p4_group_8_repo/End.png", 60, 141 + 141-13,96));
		background.add(new Final("file:src/p4_group_8_repo/End.png", 60, 141 + 141-13+141-13+1,96));
		background.add(new Final("file:src/p4_group_8_repo/End.png", 60, 141 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png", 40, 300, 706.4666);
		background.add(animal);
		background.add(new Car("file:src/p4_group_8_repo/truck1"+"Right.png", 120, 0, 649, 1));
		background.add(new Car("file:src/p4_group_8_repo/truck1"+"Right.png", 120, 300, 649, 1));
		background.add(new Car("file:src/p4_group_8_repo/truck1"+"Right.png", 120, 600, 649, 1));
		//background.add(new Car("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Car("file:src/p4_group_8_repo/car1Left.png", 50, 100, 597, -1));
		background.add(new Car("file:src/p4_group_8_repo/car1Left.png", 50, 250, 597, -1));
		background.add(new Car("file:src/p4_group_8_repo/car1Left.png", 50, 400, 597, -1));
		background.add(new Car("file:src/p4_group_8_repo/car1Left.png", 50, 550, 597, -1));
		background.add(new Car("file:src/p4_group_8_repo/truck2Right.png", 200, 0, 540, 1));
		background.add(new Car("file:src/p4_group_8_repo/truck2Right.png", 200, 500, 540, 1));
		background.add(new Car("file:src/p4_group_8_repo/car1Left.png", 50, 500, 490, -5));
		background.add(new Digit(0, 30, 360, 25));
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
