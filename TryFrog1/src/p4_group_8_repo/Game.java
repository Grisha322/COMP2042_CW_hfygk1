package p4_group_8_repo;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class Game {
	
	private static Game instance = new Game();
	private Level currentLevel;
	private AnimationTimer timer;
	private List<Actor> gameSpaceActorSet = new ArrayList<Actor>();
	private List<Final> finals = new ArrayList<Final>();
	private List<Digit> scoreDisplay = new ArrayList<Digit>();
	private List<Digit> levelDisplay = new ArrayList<Digit>();
	private List<Digit> timeLeftDisplay = new ArrayList<Digit>();
	private Player player;
	private AudioPlayer audioPlayer = new AudioPlayer();
	private int timeLeft;
	private Pane gameScreen;
	
	private Game() {
		currentLevel = Level.NOTSET;
		audioPlayer.playMusic();
	}
	
	public static Game getInstance() {
		return instance;
	}
	
	public void setGameSpaceActorSet(List<Actor> actors) {
		gameSpaceActorSet.addAll(actors);
	}
	
	public List<Actor> getGameSpaceActorSet() {
		return gameSpaceActorSet;
	}
	
	public Level getCurrentLevel() {
		return currentLevel;
	}
	
	public void setGameScreen(Pane gameScreen) {
		this.gameScreen = gameScreen;
	}
	
	public Pane getGameScreen() {
		return gameScreen;
	}
	
	public void setCurrentlLevel(Level level) {
		currentLevel = level;
	}
	
	public void setPlayer(Actor player) {
		this.player = (Player) player;
	}
	
	public void setFinals(List<Actor> finals) {
		for(Actor actor: finals) {
			this.finals.add((Final) actor);
		}
	}
	
	public int notActiveFinalsLeft() {
		int counter = finals.size();
		for(Final finale: finals) {
			if(finale.isActivated()) {
				counter--;
			}
		}
		return counter;
	}
	
	public void setScoreDisplay(List<Actor> scoreDisplay) {
		final int index = 0;
		for(Actor actor: scoreDisplay) {
			this.scoreDisplay.add(index, (Digit) actor);
		}
	}
	
	public void setTimeLeftDisplay(List<Actor> timeLeftDisplay) {
		for(Actor actor: timeLeftDisplay) {
			this.timeLeftDisplay.add((Digit) actor);
		}
	}
	
	public void setLevelDisplay(List<Actor> levelDisplay){
		for(Actor actor: levelDisplay) {
			this.levelDisplay.add((Digit) actor);
		}
	}
	public boolean levelPassed() {
		return notActiveFinalsLeft() == 0;
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
        	
        	private long lastTime = 0;
        	
            @Override
            public void handle(long now) {
            	for (Actor anActor: gameSpaceActorSet) {
                	anActor.act();
                }
            	handleScoreChanges();
            	lastTime = handleLevelTimer(now, lastTime);
            	handleGameEnd();
            }
            
        };
    }
	
	public void toggleMusic(boolean value) {
		audioPlayer.setMusicOff(value);
	}
	
	private void handleScoreChanges() {
		if (player.scoreChanged()) {
    		display(player.getPoints(), scoreDisplay);
    	}
	}
	
	private void handleGameEnd() {
		String title = "";
		String headerText = "";
		if (levelPassed()) {
			if(currentLevel.levelToInt() == 3) {
				title = "Game Won";
				headerText = "Congratulations, You have won the game!";
			}
			else {
				title = "Level Passed";
				headerText = "Congratulations, You have passed level " + currentLevel.levelToInt() + "!";
			}
    	}
		else if(timeLeft == 0) {
			title = "Game Over";
			headerText = "Game over! No more time left.";
		}
		else if(player.lifesLeft() == 0) {
			title = "Game Over";
			headerText = "Game over! No more lifes left.";
		}
		else {
			return;
		}
		stop();
		displayGameEndAlert(title, headerText);
	}
	
	private void displayGameEndAlert(String title, String headerText) {
		Button button = new Button("OK");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText("");
		
	}
	private long handleLevelTimer(long now, long lastTime){
		if (lastTime != 0) {
            if (now > lastTime + 1_000_000_000) {
                timeLeft--;
                displayTimeLeft();
                lastTime = now;
            }
        } 
		else {
            lastTime = now;

        }
		
		return lastTime;
	}
	
	public void start() {
		timeLeft = 300;
		
		displayTimeLeft();
		
		display( currentLevel.levelToInt(), levelDisplay );
		
		audioPlayer.playMusic();
		
    	createTimer();
    	
        timer.start();
    }

    public void stop() {
    	audioPlayer.stopMusic();
    	stopGameAnimations();
        timer.stop();
    }
    
    
    public void pauseGame() {
    	stopGameAnimations();
        timer.stop();
    }
    
    public void continueGame() {
    	continueGameAnimations();
        timer.start();
    }
    
    public void stopGameAnimations() {
    	for(Actor actor: gameSpaceActorSet) {
    		if(actor instanceof animatedObject) {
    			((animatedObject) actor).stopAnimation();
    		}
    	}
    }
    
    public void continueGameAnimations() {
    	for(Actor actor: gameSpaceActorSet) {
    		if(actor instanceof animatedObject) {
    			((animatedObject) actor).continueAnimation();
    		}
    	}
    }
    
    public void displayTimeLeft() {
    	int timeLeft = this.timeLeft;
    	
    	final Digit minutes = timeLeftDisplay.get(0);
    	
    	final Digit secondsFirstDigit = timeLeftDisplay.get(1); 
    	
    	final Digit secondsSecondDigit = timeLeftDisplay.get(2); 
    	
    	minutes.setDigit(timeLeft / 60);
    	
    	timeLeft %= 60;
    	
    	secondsFirstDigit.setDigit(timeLeft / 10);
    	
    	secondsSecondDigit.setDigit(timeLeft % 10);
    }
    public void display(int number, List<Digit> display) {
    	
    	for(Digit Digit: display) {
    		final int digit = number % 10;
    		
    		Digit.setDigit(digit);
    		
    		number /= 10;
    	}
    }
	
    public int calculatePointsTotal() {
    	int total = 0;
    	total += player.getPoints();
    	total += (player.lifesLeft() * 250);
    	total += timeLeft;
    	total *= currentLevel.levelToInt();
    	return total;
    }
    
    public void reset() {
    	gameSpaceActorSet.clear();
    	finals.clear();
    	scoreDisplay.clear();
    	levelDisplay.clear();
    	timeLeftDisplay.clear();
    	player = null;
    	audioPlayer.stopMusic();
    	audioPlayer = null;
    	timeLeft = 0;
    	gameScreen = null;
    }
}
