package p4_group_8_repo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MenuController {
	@FXML
	Text musicText;
	@FXML
	Pane menu;
	@FXML
	Pane infoPage;
	@FXML
	Parent root;
	@FXML
	TitledPane gameWin;
	@FXML
	TitledPane levelWin;
	@FXML
	TitledPane timeFinished;
	@FXML
	TitledPane lifesFinished;
	@FXML
	Label froggerPoints;
	@FXML
	Label lifesSavedBonus;
	@FXML
	Label timeLeftBonus;
	@FXML
	Label levelMultiplier;
	@FXML
	Label totalPoints;
	@FXML
	Text highScore;
	@FXML
	Pane scoreBoard;
	Game game;
	@FXML
    public void initialize() {
		//Provide the game with handles for view objects
		game = Game.getInstance();
		musicText.setText("ON");
		game.setLifesFinished(lifesFinished);
		game.setTimesFinished(timeFinished);
		game.setLevelWin(levelWin);
		game.setGameWin(gameWin);
		game.setFroggerPoints(froggerPoints);
		game.setHighScore(highScore);
		game.setLevelMultiplier(levelMultiplier);
		game.setLifesSavedBonus(lifesSavedBonus);
		game.setTimeLeftBonus(timeLeftBonus);
		game.setTotalPoints(totalPoints);
		game.setScoreBoard(scoreBoard);
		openMenu();
    }
	
	//This method is used to mute the audio, called when a Music button is pressed in the main menu
	@FXML
	public void toggleMusic() {
		if(musicText.getText().equalsIgnoreCase("ON")) {
			musicText.setText("OFF");
			game.toggleMusic(true);
		}
		else {
			musicText.setText("ON");
			game.toggleMusic(false);
		}
	}
	
	//This method returns back to main from a finished game
	@FXML
	public void backToMenu() {
		openMenu();
		//clean stage from used gameSpace and reset game class 
		cleanUp();
		game.setCurrentlLevel(Level.NOTSET);
	}
	
	//This method Starts next level. It is called when user wins one of the rounds
	@FXML
	public void nextLevel() throws IOException {
		cleanUp();
		startTheGame();
	}
	
	//this method is used to clean stage from used gameScreeen and reset game class 
	public void cleanUp() {
		((Pane) root).getChildren().remove(game.getGameScreen());
		game.reset();
	}
	
	//Open menu
	@FXML
	public void openMenu(){
		menu.toFront();
	}
	
	//This mehod is used to open an info page
	@FXML
	public void openInfo(){
		infoPage.toFront();
	}
	
	//This method starts the game
	@FXML
	public void startTheGame() throws IOException {
		//sets currentlevel to next level
		final Level level = game.getCurrentLevel().nextElement();
		game.setCurrentlLevel(level);
		//Loads GameScreen and puts it to the front view, to start the gameplay
		Pane gameScreen = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
		((Pane) root).getChildren().add(gameScreen);
	    gameScreen.toFront();
	}
}
