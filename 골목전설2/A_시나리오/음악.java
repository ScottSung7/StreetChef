package A_시나리오;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class 음악 {
	
	Clip c;
	
	public void 음악(int choice) {
		
		
		Thread threadMusic = new Thread(() -> {
			
			String filePath = "";
			switch(choice) {
				case 1: filePath = "./audio/Dream.wav"; break;
				case 2: filePath = "./audio/fairy.wav"; break;
				case 3: filePath = "./audio/ring.wav"; break;
				case 4: filePath = "./audio/drum.wav"; break;
				case 5: filePath = "./audio/go.wav"; break;
				case 6: filePath = "./audio/battle.wav"; break;
					
			}
			
			
				
				File a = new File(filePath);
				AudioInputStream b;
				
				try {
					
					
					b = AudioSystem.getAudioInputStream(a);
					c = AudioSystem.getClip();
					c.open(b);
					c.start();
					
					
					
					Thread.sleep(c.getMicrosecondLength()/1000);
				
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			
		});
		threadMusic.start();

	}
	public void 음악중지() {
		c.stop();
	}

}
