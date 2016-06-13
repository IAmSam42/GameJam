package audioController;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import engine.entities.Player;
import engine.entities.Robot;

public class RobotAudio {
	Robot robot;
	Player player;
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
				clip.start();			
				

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mute(true);
	}
	

	
	public void mute(boolean isMuted){
		BooleanControl muteControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
		muteControl.setValue(isMuted);
	}
	
	public void setPan(double pan){
		FloatControl pand = (FloatControl) clip.getControl(FloatControl.Type.PAN);
		pand.setValue((float)pan);
	}
	
	public void tick(){
		mute(true);
		int distSqr = ((player.getXCoord()-robot.getXCoord())*(player.getXCoord()-robot.getXCoord())) + ((player.getYCoord()-robot.getYCoord())*(player.getYCoord()-robot.getYCoord()));
		double distance = Math.sqrt((double)distSqr);
		
		if(distance<320)
		{
			mute(false);
			double panAmount = (double)(robot.getXCoord()-player.getXCoord())/(double)320;
			setPan(panAmount);
		}
		

		
		
	}
}
