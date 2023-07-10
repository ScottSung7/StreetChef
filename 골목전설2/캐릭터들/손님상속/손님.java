package 캐릭터들.손님상속;

import 오픈중.요리모음.요리;
import 캐릭터들.집안.주인공;

import java.util.Random;

import 오픈중.요리모음.메뉴;

public class 손님 {
	 
	//int 손님번호 = 0;
	String 손님성함; 
	요리 주문내역;
	Random random = new Random();
	public boolean 추가주문_여부 = false;
	
	public 손님(int 손님번호){
		손님성함 = "손님 " + (손님번호 + 1);
	}
	
//	public 요리 주문(메뉴 메뉴) {
//		return 메뉴.주문();}
	public void 주문(메뉴 메뉴) {
		주문내역 = 메뉴.주문();
		주문내역.set추가주문(추가주문());
	}
	private String 추가주문() {
		int check = random.nextInt(5);
		String 추가주문 = null; 
		switch(check) {
		case 0: 추가주문 = "반찬추가"; 		break;	
		case 1: 추가주문 = "없음"; 			break;	
		case 2: 추가주문 = "곱배기"; 		break;	
		case 3: 추가주문 = "맵게";			break;	
		case 4: 추가주문 = "포장";			break;	
		
		}
		
		return 추가주문;
	}
	
	public boolean 후기(요리 요리, 주인공 주인공) {
		int 평판;		boolean 후기_결과; 
		
		if(요리.get메뉴명().equals(주문내역.get메뉴명()) ? true : false) {
			평판 = 500;	주인공.평판계산(평판);
			후기_결과 = true;
		}else {
			평판 =0; 		주인공.평판계산(0);
			후기_결과 =  false;
		}
		
		return 후기_결과; 
	}

	
	//Getter Setter
	//public int get손님번호() 		{return 손님번호;}
	public String get손님성함() 	{return 손님성함;}
	public 요리 	  get주문내역() 	{return 주문내역;}
	public String get추가주문내역() 	{return 주문내역.get추가주문();}

	
	
}
