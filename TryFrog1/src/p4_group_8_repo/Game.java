package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Game {
	
	private static Game instance = new Game();
	private Level currentLevel;
	private AnimationTimer timer;
	private List<Final> finals = new ArrayList<Final>();
	private List<Digit> scoreDisplay = new ArrayList<Digit>();
	private List<Digit> levelDisplay = new ArrayList<Digit>();
	private List<Digit> timeLeftDisplay = new ArrayList<Digit>();
	private Player player;
	private MyStage window = new MyStage();
	private int timeLeft;
	
	private Game() {
		currentLevel = Level.ONE;
		window.playMusic();
	}
	
	private int levelToNum(Level level) {
		int number = 0;
		if(level.equals(Level.ONE)) {
			number = 1;
		}
		else if(level.equals(Level.TWO)) {
			number = 2;
		}
		else if(level.equals(Level.THREE)) {
			number = 3;
		}
		else if(level.equals(Level.NOTSET)) {
			number = 0;
		}
		return number;
	}
	
	public static Game getInstance() {
		return instance;
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
            	handleScoreChanges();
            	handleLevelPassed();
            	lastTime = handleLevelTimer(now, lastTime);
            }
            
        };
    }
	
	public void toggleMusic(boolean value) {
		window.setMusicOff(value);
	}
	
	private void handleScoreChanges() {
		if (player.scoreChanged()) {
    		display(player.getPoints(), scoreDisplay);
    	}
	}
	
	private void handleLevelPassed() {
		if (levelPassed()) {
    		System.out.print("STOPP:");
    		window.stopMusic();
    		stop();
    		window.stop();
    		stop();
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("You Have Won The Game!");
    		alert.setHeaderText("Your Score: " + player.getPoints() +"!");
    		alert.setContentText("Highest Possible Score: 800");
    		alert.show();
    	}
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
		if(timeLeft == 0) {
			
		}
		return lastTime;
	}
	
	public void start() {
		timeLeft = 300;
		
		displayTimeLeft();
		
		display( levelToNum(currentLevel), levelDisplay );
		
		window.playMusic();
		
    	createTimer();
    	
        timer.start();
    }

    public void stop() {
        timer.stop();
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
	
}
