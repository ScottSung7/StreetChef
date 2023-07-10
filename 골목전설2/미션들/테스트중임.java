package 미션들;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import A_시나리오.시나리오;


public class 테스트중임 {
	
	 static JFrame jFrame = new JFrame();
	
	public static void clearScreen() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
	public static void clearScreen2() throws IOException {
		  Runtime.getRuntime().exec("clear");
	}
	
	public static void main(String[] args){
		System.out.println("하이하");
		jFrame.setAlwaysOnTop(true);
	      JOptionPane.showMessageDialog(jFrame, "Hello there! How are you today?");
		//	String a ="HIIIIII";
	   //     JOptionPane jop = new JOptionPane();
	  //      jop.setMessageType(JOptionPane.PLAIN_MESSAGE);
	  //     jop.setMessage(a);
	  //     JDialog dialog = jop.createDialog(null, "Message");
	        
	       new Thread(new Runnable() {
	    	    @Override
	    	    public void run() {
	    	        try {
						 Thread.sleep(2000);
	    	        } catch (Exception e) {
	    	        }
	    	      //  dialog.dispose();
	    	    }

	    	}).start();
	       
	      Thread thread =  new Thread(new Runnable() {
	    	    @Override
	    	    public void run() {
	    	     JOptionPane.showMessageDialog(jFrame, "Hello222");
	    	     
	    	       // dialog.dispose();
	    	    }

	    	});
	        
	     // dialog.setVisible(true);
		       
		    시나리오 시나리오 = new 시나리오();
		    시나리오.엔터();
		    if(true) {
		    	System.out.println("gkkk");
		    	//thread.start();
		    	hi();	
		    }
		    
	}
	
	public static void hi() {
		JOptionPane.showMessageDialog(jFrame, "Hello there! How are you today?2222");
	}
		       
	        

}
