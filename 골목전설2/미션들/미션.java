package 미션들;

import A_시나리오.시나리오;
import 오픈중.요리모음.중식메뉴.A_중식;
import 오픈중.요리모음.한식메뉴.A_한식;
import 캐릭터들.집안.주인공;

public class 미션 {
	
	protected String 미션타입;
	protected String 미션번호; 
	protected String 미션이름; 
	protected String 진행상태;
	protected String 미션내용;
	protected boolean 대결 = false;
	
	protected int 목표_성공_수; 
	protected 미션보드_정보 정보;
	A_한식 한식;
	protected String 특기_한식;
	A_중식 중식;
	protected String 특기_중식; 
	
	protected boolean 성공여부;
	
	public 미션(){
		한식 = new A_한식();
		특기_한식 = 한식.get메뉴타입();
		중식 = new A_중식();
		특기_중식 = 중식.get메뉴타입();
	}
	
	public String get미션타입() {
		return 미션타입;
	}


	public void 상태출력(int 상태) {
		switch(상태) {
		case 0: 시나리오.출력("상태: 진행 중"); break;
		case 1: 시나리오.출력("상태: 성공"); break;}
	}
	
	
	public boolean 미션체크(미션보드_정보 정보) {
		
		return true;
	}
	public void 미션_보상(주인공 주인공) {
		
	}
	public void 대결(주인공 주인공) {
		
	}

	public String get미션번호() {
		return 미션번호;
	}
	public String get미션이름() {
		return 미션이름;
	}
	public String get미션내용() {
		return 미션내용;
	}
	public String get진행상태() {
		return 진행상태;
	}
	public boolean get성공여부() {
		return 성공여부;
	}
	public void set성공여부(boolean 성공) {
		성공여부 = 성공;
	}
	public String get특기_한식() {
		return 특기_한식;
	}
	public String get특기_중식() {
		return 특기_중식; 
	}
	
}
