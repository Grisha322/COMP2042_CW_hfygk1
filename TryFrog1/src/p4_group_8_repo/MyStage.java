package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyStage extends World{
	private MediaPlayer mediaPlayer;
	private boolean isPlaying = false;
	private boolean musicOff = false;
	public MyStage() {}
	
	public void playMusic() {
		if(musicOff) {
			return;
		}
		String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	    isPlaying = true;
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
		isPlaying = false;
	}
	
	public void setMusicOff(boolean value) {
		musicOff = value;
		if(isPlaying && value) {
			stopMusic();
		}
		if(!isPlaying && !value) {
			
			playMusic();
		}
	}
}
