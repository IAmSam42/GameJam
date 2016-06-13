package audioController;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import engine.entities.Player;
import engine.entities.Robot;

public class RobotAudio {
	Robot robot;
	Player player;
	FloatControl gainControl;
	Clip clip;
	public RobotAudio(Robot robot, Player player) {
		Random gen = new Random();
		String fileURL = "";
		if(gen.nextFloat()<.5){
			fileURL = "resources/music/Beep.wav";
		} else {
			fileURL = "resources/music/Beep2.wav";
		}
		this.robot = robot;
		this.player = player;
	
		AudioInputStream audioInputStream;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(fileURL));
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void tick(){
		if(robot.isTracking())
			clip.start();
		
	}
}
