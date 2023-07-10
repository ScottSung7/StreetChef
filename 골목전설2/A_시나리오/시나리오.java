package A_시나리오;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import 상권.A_마을;
import 캐릭터들.집안.주인공;


public class 시나리오 {
	
	public static String 있음 = "있음";
	public static String 없음 = "없음";
	public static String 선나누기 = "=====================================";
	public static String 추가 = "추가";
	public static String 주인공_인사멘트(String 이름) {
		return "\n안녕하세요. "+이름+" 입니다.";
	}
	public static String 주인공_영업시작멘트() {
		return  "영업을 시작했습니다.😀😄\n";
	}

	
	//출력
	public static void 출력(String 내용){
		System.out.println(내용);
	}
	public static void 첫줄(String 내용){
		System.out.println("\n"+내용);
	}
	public static void 한줄(String 내용){
		System.out.print("\n"+내용);
	}
	public static void 같은줄(String 내용){
		System.out.print(내용);
	}
	public static void 리스트_출력(String 첫줄, List<String> 리스트) {
		
		첫줄(첫줄);
		AtomicInteger index = new AtomicInteger(1);
		리스트.forEach(val ->{
			출력(index + ". "+ val);
			index.getAndIncrement();
		});
		
	}
	//선택
	public 주인공 캐릭터선택(주인공 주인공) {
		
		return 주인공.캐릭터선택(주인공);
	}
	public static int 선택() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	public static void 영업선택(주인공 주인공) {
		
		음악 음악 = new 음악();
		음악.음악(2);
		주인공.대기중 = false;
		System.out.println("\n활동을 선택해 주세요.\n\n"
		+ "1.영업 시작     2.정보 보기     3.마을로 나가기     4.미션 시작 ");	
		System.out.print("\n선택한 활동: ");

			
		int 영업선택 = 선택();
		switch(영업선택) {
			case 1: 음악.음악중지(); 주인공.영업중(주인공);		 	break;
			case 2: 주인공.정보보기(주인공); 	 					break;
			case 3: 음악.음악중지(); new A_마을().마을환영인사(주인공);				break;
			case 4: 음악.음악중지(); 
					if(주인공.미션보드.get진행중_미션() == null) {
						주인공.미션보드.미션_선택(주인공);
				if(!주인공.미션보드.get대결중()) {
							돌아가기(주인공);
						};
					
						주인공.미션보드.진행상태();
						돌아가기(주인공);
					}
					break;
		}
	}
	
	public static void 돌아가기(주인공 주인공) {
		
		출력("\n\n돌아가시겠습니까? ");
		엔터();		
		영업선택(주인공);
	}
	public static void 엔터() {
		출력("\n[계속하려면 Enter 키를 눌러주세요]");
	    try {
	    	System.in.read(); System.in.skip(2); 
	    } catch (IOException e) { 
	    	
	    }
	}
	public void 초기화() throws IOException {
		
		System.in.skip(2);
	}
	public static void 스레드_잠자기_도우미() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	public  static void 점점점(String 멘트) {
	
		int startCount = 0;
			
		while(true) {
			try {
				
				if(startCount == 3) {출력(멘트); break;}
				같은줄(". ");
				
				Thread.sleep(1000);
				startCount++; 
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	public static void 대기(주인공 주인공) {
		
		Thread thread5 = new Thread(()->{
			boolean 대기중_작동;
			int tenSecondsTo = 10000;
			int fifteenSeconds = 15000;
			
			while(true) {
				Random random = new Random();
				int sleepTime = tenSecondsTo + random.nextInt(fifteenSeconds);
				JOptionPane pane = new JOptionPane("Timers", JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = 넌모달다이얼로그세팅(pane);
				
				String[] words = {"오늘 대박 기운인걸?", "손님인가...?", "단골손님이다!",
						"준비를 좀 더 해볼까?", "아자자 파이팅!"};
				List<String> wordsList = Arrays.asList(words);
				
				try {
					Thread.sleep(sleepTime);
					if(주인공.대기중) {
						pane.setMessage(wordsList.get(random.nextInt(wordsList.size()-1)));
						dialog.setVisible(true);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		});
		thread5.start();
				
	}
	
	public static void 타이머(주인공 주인공, int 입력시간) {
		
		주인공.set타임어택완료(false);
		Thread thread3 = new Thread(()->{
			
			int 시간_분 = 입력시간;
			List<Integer> 시간 = 시간_세팅(시간_분);
			
			Integer time = 0;
			String 현재시간;
			
			JOptionPane pane = new JOptionPane("Timers", JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = 넌모달다이얼로그세팅(pane);
		
			while(true) {
				try {
					//분침
					if(time == 0 || 주인공.get타임어택완료()) {
						if(시간.size() == 0 || 주인공.get타임어택완료()) {//시간 끝 
							if(주인공.get타임어택완료()) {
								pane.setMessage("타임어택 완료");
								break;
								
							}else {
								주인공.set타임어택실패(true);
								pane.setMessage("타임어택 실패");
								dialog.setVisible(false);
								//주인공.미션보드.정보.set대결종료(true);
								//주인공.미션보드.대결.interrupt();
								
								//시나리오.영업선택(주인공);
								break;
							}
						}
						time = 시간.get(시간.size()-1);
						시간.remove((시간.size()-1));
					}
					time = time -1;
					
					현재시간 = 시간출력(time, 시간);
					pane.setMessage(현재시간);
					dialog.setVisible(true);
					
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		thread3.start();
		
	}
	private static List<Integer> 시간_세팅(int 시간_분){
		List<Integer> 시간 = 	new ArrayList<Integer>();
		
		for(int i = 0; i < 시간_분; i++) {
			시간.add(60);
		}
		
		return 시간; 
	}
	private static JDialog 넌모달다이얼로그세팅(JOptionPane pane) {
		JDialog dialog =pane.createDialog(null, "Timer");
		dialog.setAlwaysOnTop(true);
		dialog.setModal(false);
		return dialog;
	}
	public static boolean 분침(int time, List<Integer> 시간) {
		if(time == 0) {
			if(시간.size() == 0) {
				return true;
			}
			time = 시간.get(시간.size()-1);
			시간.remove((시간.size()-1));
		}
		return false;
	}
	public static String 시간출력(int time, List<Integer> 시간) {
		
		String 분 = 시간.size() > 0 ? (시간.size() + ":") : "";
		
		return (시간.size()+" : " + time);
		
	}
	public static void 음악(int choice, int time) {
		int sleepTime = time;
		
		
		Thread threadMusic = new Thread(() -> {
			
			String filePath = "";
			switch(choice){
				case 1: filePath = "./audio/Dream.wav"; break;
				case 2: filePath = "./audio/fairy.wav"; break;
				case 3: filePath = "./audio/ring.wav"; break;
				case 4: filePath = "./audio/drum.wav"; break;
				case 5: filePath = "./audio/go.wav"; break;
				case 6: filePath = "./audio/battle.wav"; break;
							
			}
			
				
				File file = new File(filePath);
				AudioInputStream audio;
				Clip clip;
				
				try {
					audio = AudioSystem.getAudioInputStream(file);
					clip = AudioSystem.getClip();
					clip.open(audio);
					clip.start();
				
					
					Thread.sleep(time);
					clip.stop();
					
					Thread.sleep(clip.getMicrosecondLength()/1000);
					
				
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
	
	
}
