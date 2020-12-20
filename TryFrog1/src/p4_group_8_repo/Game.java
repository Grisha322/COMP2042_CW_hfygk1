package p4_group_8_repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

//This class is a controller class for the game processing.
public class Game {
	
	private static Game instance = new Game();
	private List<Integer> highScoreList = new ArrayList<Integer>();
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
	private TitledPane gameWin;
	private TitledPane levelWin;
	private TitledPane timeFinished;
	private TitledPane lifesFinished;
	private Label froggerPoints;
	private Label lifesSavedBonus;
	private Label timeLeftBonus;
	private Label levelMultiplier;
	private Label totalPoints;
	private Text highScore;
	private Pane scoreBoard;
	
	//Game is a Singleton Object
	private Game(){
		currentLevel = Level.NOTSET;
		audioPlayer.playMusic();
		
	}
	
	public static Game getInstance() {
		return instance;
	}
	
	//Setters for all the fields and Getter for some.
	
	public void setScoreBoard(Pane scoreBoard) {
		this.scoreBoard = scoreBoard;
	}
	
	public void setLevelMultiplier(Label levelMultiplier) {
		this.levelMultiplier = levelMultiplier;
	}

	public void setFroggerPoints(Label froggerPoints) {
		this.froggerPoints = froggerPoints;
	}

	public void setLifesSavedBonus(Label lifesSavedBonus) {
		this.lifesSavedBonus = lifesSavedBonus;
	}

	public void setTimeLeftBonus(Label timeLeftBonus) {
		this.timeLeftBonus = timeLeftBonus;
	}

	public void setTotalPoints(Label totalPoints) {
		this.totalPoints = totalPoints;
	}

	public void setHighScore(Text highScore) {
		this.highScore = highScore;
	}

	public void setGameWin(TitledPane gameWin) {
		this.gameWin = gameWin;
	}

	public void setLevelWin(TitledPane levelWin) {
		this.levelWin = levelWin;
	}
	
	public void setTimesFinished(TitledPane timeFinished) {
		this.timeFinished = timeFinished;
	}
	public void setLifesFinished(TitledPane lifesFinished) {
		this.lifesFinished = lifesFinished;
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
	
	//This method checks for the amount of non activated Finals.
	public int notActiveFinalsLeft() {
		int counter = finals.size();
		for(Final finale: finals) {
			if(finale.isActivated()) {
				counter--;
			}
		}
		return counter;
	}
	
	//This method checks if the round was won
	public boolean roundWon() {
		return notActiveFinalsLeft() == 0;
	}
	
	//This method creates a game timer. Every tick, act method of each actor is called plus game state is managed 
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
	
	//This method is used to mute audioPlayer
	public void toggleMusic(boolean value) {
		audioPlayer.setMusicOff(value);
	}
	
	//This method handles players score changed, by displaying it on a score display
	private void handleScoreChanges() {
		if (player.scoreChanged()) {
    		display(player.getPoints(), scoreDisplay);
    	}
	}
	
	//This method checks and handles game end
	private void handleGameEnd() {
		//An appropriate scene is displayed according to end game scenario
		if (roundWon()) {
			if(currentLevel.elementsLeft()) {
				levelWin.toFront();
			}
			else {
				gameWin.toFront();
			}
    	}
		else if(timeLeft == 0) {
			timeFinished.toFront();
		}
		else if(player.lifesLeft() == 0) {
			lifesFinished.toFront();
		}
		else {
			return;
		}
		stop();
		//after each round regardless of results fill up the scoreboard and display it
		fillScoreBoard();
		scoreBoard.toFront();
	}
	
	//Update round timer according to game timer
	private long handleLevelTimer(long now, long lastTime){
		if (lastTime != 0) {
			//each second is 1_000_000_000 ticks
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
	
	//this method Starts game
	public void start() {
		timeLeft = 300;
		
		displayTimeLeft();
		
		display( currentLevel.levelToInt(), levelDisplay );
		
		audioPlayer.playMusic();
		
    	createTimer();
    	
        timer.start();
    }
	
	//this method Stops game
    public void stop() {
    	audioPlayer.stopMusic();
    	stopGameAnimations();
        timer.stop();
    }
    
    //this method pauses game
    public void pauseGame() {
    	stopGameAnimations();
        timer.stop();
    }
    
    //this method continue game
    public void continueGame() {
    	continueGameAnimations();
        timer.start();
    }
    
    //Stop all animations
    public void stopGameAnimations() {
    	for(Actor actor: gameSpaceActorSet) {
    		if(actor instanceof AnimatedObject) {
    			((AnimatedObject) actor).stopAnimation();
    		}
    	}
    }
    
    //Continue all animations
    public void continueGameAnimations() {
    	for(Actor actor: gameSpaceActorSet) {
    		if(actor instanceof AnimatedObject) {
    			((AnimatedObject) actor).continueAnimation();
    		}
    	}
    }
    
    //Update timer display with a time left
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
    
    //Set normal integers on an appropriate display
    public void display(int number, List<Digit> display) {
    	
    	for(Digit Digit: display) {
    		//obtain last digit
    		final int digit = number % 10;
    		
    		Digit.setDigit(digit);
    		//reduce the number with one digit
    		number /= 10;
    	}
    }
	
    //This method calculates total number of points for the round
    public int calculatePointsTotal() {
    	final int eachLifeSavedBonus = 250;
    	
    	int total = 0;
    	
    	total += player.getPoints();
    	//Adding bonuses for the round win
    	total += (roundWon() ? player.lifesLeft() * eachLifeSavedBonus : 0);
    	
    	total += (roundWon() ? timeLeft : 0);
    	//Points are multiplied according to the level difficulty
    	total *= currentLevel.levelToInt();
    	
    	return total;
    }
    
    //This method fills labels of the scoreBoard and then displays it
    private void fillScoreBoard() {   	
    	final int eachLifeSavedBonus = 250;
    	
    	final int total = calculatePointsTotal();
    	
    	froggerPoints.setText("" + player.getPoints());
    	
    	lifesSavedBonus.setText("" + (roundWon() ? player.lifesLeft() * eachLifeSavedBonus : 0) );
    	
    	timeLeftBonus.setText("" +  (roundWon() ? timeLeft : 0));
    	
    	levelMultiplier.setText("X" + currentLevel.levelToInt());
    	
    	totalPoints.setText("" + total);
    	
    	updateHighScoreList(total);
    	
    	displayHighScoreBoard();
    	
    }
    
    //Update HighScore list with a value for this round
    private void updateHighScoreList(Integer total) {
		highScoreList.add(total);
		//Sort a list in a descending order
		Collections.sort(highScoreList, Collections.reverseOrder());
		//Truncate the list to keep only three best results
		if(highScoreList.size() > 3) {
			highScoreList.subList(3, highScoreList.size()).clear();
		}
	}
    
    //Display high score board
    private void displayHighScoreBoard() {
    	String highScoreBoard = "";
    	
    	Integer iterator = 1;
    	
    	for(Integer num: highScoreList) {
    		highScoreBoard += (iterator.toString() + ".\t" + num.toString() + "\n");
    		iterator++;
    	}
    	
    	highScore.setText(highScoreBoard);
    }
    
    //This method is used to reset actor handles, to prepare for the next game
	public void reset() {
    	gameSpaceActorSet.clear();
    	finals.clear();
    	scoreDisplay.clear();
    	levelDisplay.clear();
    	timeLeftDisplay.clear();
    	player = null;
    	timeLeft = 0;
    	gameScreen = null;
    }
}
