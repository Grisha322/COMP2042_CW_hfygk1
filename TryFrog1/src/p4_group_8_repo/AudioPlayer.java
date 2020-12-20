package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * This is a wrapper class for mediaPlayer. It is used to play background music. Also supports muting function
 * @author hfygk1
 *
 */
public class AudioPlayer{
	private MediaPlayer mediaPlayer;
	private boolean isPlaying = false;
	private boolean musicOff = false;
	public AudioPlayer() {}
	
	/**
	 * Starts the music, if musicOff flag is not set to true
	 */
	public void playMusic() {
		//if audio is muted, music won't even start playing
		if(musicOff || isPlaying) {
			return;
		}
		String musicFile = "src/p4_group_8_repo/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	    isPlaying = true;
	}
	
	/**
	 * Stops music.
	 */
	public void stopMusic() {
		if(isPlaying) {
			mediaPlayer.stop();
		}
		isPlaying = false;
	}
	
	/**
	 * Mutes and unmutes the music.
	 * @param value of mute flag, true for muting and false for unmuting
	 */
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
