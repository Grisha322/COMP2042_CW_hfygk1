package p4_group_8_repo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class menuController {
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
    }
	
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
	
	@FXML
	public void backToMenu() {
		openMenu();
		cleanUp();
		game.setCurrentlLevel(Level.NOTSET);
	}
	
	@FXML
	public void nextLevel() throws IOException {
		cleanUp();
		startTheGame();
	}
	
	public void cleanUp() {
		((Pane) root).getChildren().remove(game.getGameScreen());
		game.reset();
	}
	
	@FXML
	public void openMenu(){
		menu.toFront();
	}
	
	@FXML
	public void openInfo(){
		infoPage.toFront();
	}
	
	@FXML
	public void startTheGame() throws IOException {
		final Level level = game.getCurrentLevel().nextElement();
		game.setCurrentlLevel(level);
		Pane gameScreen = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
		((Pane) root).getChildren().add(gameScreen);
	    gameScreen.toFront();
	}
}
