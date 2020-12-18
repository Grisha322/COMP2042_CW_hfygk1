package p4_group_8_repo;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Controller{
	@FXML
	VBox root;
	@FXML
	Pane gameSpace;
	@FXML
	Pane startPane;
	@FXML
	Pane roadPane1;
	@FXML
	Pane roadPane2;
	@FXML
	Pane roadPane3;
	@FXML
	Pane roadPane4;
	@FXML
	Pane safePane;
	@FXML
	Pane waterPane1;
	@FXML
	Pane waterPane2;
	@FXML
	Pane waterPane3;
	@FXML
	Pane waterPane4;
	@FXML
	Pane end;
	@FXML
	Pane lifesContainer;
	@FXML
	Pane timeContainer;
	@FXML
	Pane scoreContainer;
	@FXML
	Pane levelContainer;
	
	@FXML
    public void initialize() {
		
		LevelSettings levelSettings = LevelOneSettings.getInstance();
		ActorGroupAdder GroupAdder = new ActorGroupAdder();
		Game game = Game.getInstance();
		
		addCars(GroupAdder, levelSettings);
		addTracks(GroupAdder, levelSettings);
		addTurtles(GroupAdder, levelSettings);
		addLogs(GroupAdder, levelSettings);
		
		final List<Actor> lifes = addLifes(GroupAdder);
		final List<Actor> finals = addFinals(GroupAdder);
		final List<Actor> scoreDisplay = addDigits(GroupAdder, 5, scoreContainer);
		final List<Actor> timeDisplay = addDigits(GroupAdder, 3, timeContainer);
		final List<Actor> levelDisplay = addDigits(GroupAdder, 1, levelContainer);
		
		Actor frogger = new Frogger("file:src/p4_group_8_repo/froggerUp.png", 32, 284, 64, lifes);
		startPane.getChildren().add((ImageView) frogger);
		
		game.setPlayer(frogger);
		game.setFinals(finals);
		game.setScoreDisplay(scoreDisplay);
		game.setTimeLeftDisplay(timeDisplay);
		game.setLevelDisplay(levelDisplay);
		//game.start();
    }
	
	private void addCars(ActorGroupAdder GroupAdder, LevelSettings settings) {
		GroupAdder.initiActorGroupAdder("MovingObstacleFactory", "Car", "file:src/p4_group_8_repo/car1Left.png");
		GroupAdder.setSize(50);
		GroupAdder.setAmount(settings.get(LevelKeys.AMOUNT_OF_CARS).intValue());
		GroupAdder.setSpeed(settings.get(LevelKeys.SPEED_OF_CARS));
		GroupAdder.setDistanceBetweenActors(settings.get(LevelKeys.DISTANCE_BETWEEN_CARS));
		GroupAdder.AddToLine(roadPane2);
		
		GroupAdder.initiActorGroupAdder("MovingObstacleFactory", "Car", "file:src/p4_group_8_repo/car1right.png");
		GroupAdder.setSize(50);
		GroupAdder.setAmount(settings.get(LevelKeys.AMOUNT_OF_FAST_CARS).intValue());
		GroupAdder.setSpeed(settings.get(LevelKeys.SPEED_OF_FAST_CARS));
		GroupAdder.setDistanceBetweenActors(settings.get(LevelKeys.DISTANCE_BETWEEN_FAST_CARS));
		GroupAdder.AddToLine(roadPane4);
	}
	
	private void addTracks(ActorGroupAdder GroupAdder, LevelSettings settings) {
		
		GroupAdder.initiActorGroupAdder("MovingObstacleFactory", "Car", "file:src/p4_group_8_repo/truck1Right.png");
		GroupAdder.setSize(100);
		GroupAdder.setAmount(settings.get(LevelKeys.AMOUNT_OF_TRACKS).intValue());
		GroupAdder.setSpeed(settings.get(LevelKeys.SPEED_OF_TRACKS));
		GroupAdder.setDistanceBetweenActors(settings.get(LevelKeys.DISTANCE_BETWEEN_TRACKS));
		GroupAdder.AddToLine(roadPane1);
		
		GroupAdder.initiActorGroupAdder("MovingObstacleFactory", "Car", "file:src/p4_group_8_repo/truck2Left.png");
		GroupAdder.setSize(150);
		GroupAdder.setAmount(settings.get(LevelKeys.AMOUNT_OF_LONG_TRACKS).intValue());
		GroupAdder.setSpeed(settings.get(LevelKeys.SPEED_OF_LONG_TRACKS));
		GroupAdder.setDistanceBetweenActors(settings.get(LevelKeys.DISTANCE_BETWEEN_LONG_TRACKS));
		GroupAdder.AddToLine(roadPane3);
	}
	
	private void addTurtles(ActorGroupAdder GroupAdder, LevelSettings settings) {
		GroupAdder.initiActorGroupAdder("MovingObstacleFactory", "Turtle", "file:src/p4_group_8_repo/TurtleAnimation2.png");
		GroupAdder.setSize(130);
		GroupAdder.setAmount(settings.get(LevelKeys.AMOUNT_OF_TURTLES).intValue());
		GroupAdder.setSpeed(settings.get(LevelKeys.SPEED_OF_TURTLES));
		GroupAdder.setDistanceBetweenActors(settings.get(LevelKeys.DISTANCE_BETWEEN_TURTLES));
		GroupAdder.AddToLine(waterPane1);
		
		GroupAdder.initiActorGroupAdder("MovingObstacleFactory", "WetTurtle", "file:src/p4_group_8_repo/TurtleAnimation1.png");
		GroupAdder.setSize(130);
		GroupAdder.setAmount(settings.get(LevelKeys.AMOUNT_OF_WET_TURTLES).intValue());
		GroupAdder.setSpeed(settings.get(LevelKeys.SPEED_OF_WET_TURTLES));
		GroupAdder.setDistanceBetweenActors(settings.get(LevelKeys.DISTANCE_BETWEEN_WET_TURTLES));
		GroupAdder.AddToLine(waterPane3);
	}
	
	private void addLogs(ActorGroupAdder GroupAdder, LevelSettings settings) {
		GroupAdder.initiActorGroupAdder("MovingObstacleFactory", "Log", "file:src/p4_group_8_repo/log2.png");
		GroupAdder.setSize(150);
		GroupAdder.setAmount(settings.get(LevelKeys.AMOUNT_OF_LOGS).intValue());
		GroupAdder.setSpeed(settings.get(LevelKeys.SPEED_OF_LOGS));
		GroupAdder.setDistanceBetweenActors(settings.get(LevelKeys.DISTANCE_BETWEEN_LOGS));
		GroupAdder.AddToLine(waterPane2);
		
		GroupAdder.initiActorGroupAdder("MovingObstacleFactory", "Log", "file:src/p4_group_8_repo/Logs.png");
		GroupAdder.setSize(300);
		GroupAdder.setAmount(settings.get(LevelKeys.AMOUNT_OF_LONG_LOGS).intValue());
		GroupAdder.setSpeed(settings.get(LevelKeys.SPEED_OF_LONG_LOGS));
		GroupAdder.setDistanceBetweenActors(settings.get(LevelKeys.DISTANCE_BETWEEN_LONG_LOGS));
		GroupAdder.AddToLine(waterPane4);
	}
	
	private List<Actor> addFinals(ActorGroupAdder GroupAdder) {
		GroupAdder.initiActorGroupAdder("StaticFactory", "Final", "file:src/p4_group_8_repo/End.png");
		GroupAdder.setSize(64);
		GroupAdder.setAmount(5);
		GroupAdder.setDistanceBetweenActors(68);
		return GroupAdder.AddToLine(end);
	}
	
	private List<Actor> addLifes(ActorGroupAdder GroupAdder) {
		GroupAdder.initiActorGroupAdder("StaticFactory", "Life", "file:src/p4_group_8_repo/Heart.png");
		GroupAdder.setSize(32);
		GroupAdder.setAmount(3);
		return GroupAdder.AddToLine(lifesContainer);
	}
	
	private List<Actor> addDigits(ActorGroupAdder GroupAdder, int amount, Pane pane){
		GroupAdder.initiActorGroupAdder("StaticFactory", "Digit", "file:src/p4_group_8_repo/0.png");
		GroupAdder.setSize(32);
		GroupAdder.setAmount(amount);
		return GroupAdder.AddToLine(pane);
	}
}
