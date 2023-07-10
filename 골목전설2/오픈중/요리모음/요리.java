package 오픈중.요리모음;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import A_시나리오.시나리오;

public class 요리 {
	
	protected String 메뉴명;
	protected int 조리시간;
	protected List<String> 레시피;
	protected String 메뉴타입;
	String	추가주문; 
	
	public 요리() {}
	
	public void 요리세팅(String 메뉴명, int 조리시간, List<String> 레시피) {
		this.메뉴명 = 메뉴명;
		this.조리시간 = 조리시간;
		this.레시피 = 레시피;
	}
	
	
	public boolean 요리자격(String 특기) {
	
		int check = 특기.equals(메뉴타입) ? 1 : 0;
		//System.out.println(check);
		switch(check) {
		case 0: return true; 
		case 1: return true;
		default: return false;
		}}

	public void hi() {
		System.out.println(조리시간);
		System.out.println(레시피);
		System.out.println(메뉴타입);
	}
	//2.0 출력
	public void 레시피_출력() {
		String 첫줄 = 메뉴명 + "의 레시피 입니다.";
		시나리오.리스트_출력(첫줄, 레시피);
	}
	
	//	
	
	public int get조리시간() 			{return 조리시간;}
	public String get메뉴명() 		{return 메뉴명;}
	public List<String> get레시피() 	{return 레시피;}
	public String get메뉴타입() 		{return 메뉴타입;}

	public String get추가주문() {
		return 추가주문;
	}

	public void set추가주문(String 추가주문) {
		this.추가주문 = 추가주문;
	}
	
}
