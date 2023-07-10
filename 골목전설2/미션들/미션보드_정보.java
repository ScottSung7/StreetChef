package 미션들;

import 상권.아이템들.주방도구들.팬류들.A_팬들;
import 오픈중.요리모음.중식메뉴.A_중식;
import 오픈중.요리모음.한식메뉴.A_한식;

public class 미션보드_정보 {
	
	public boolean 체크; 
	public int 요청사항_성공_수;
	public int 추가주문_성공_수;
	public int 서빙_성공_수; 
	
	public boolean 팬_여부;
	public boolean 화구_여부;
	public boolean 직원_여부;
	
	public boolean 대결종료 = false;
	public float 평점; 
	
	미션보드_정보(){
	}
	
	
	public int get요청사항_성공_수() {
		return 요청사항_성공_수;
	}
	public int get서빙_성공_수() {
		return 서빙_성공_수;
	}
	public void set대결종료(boolean 대결종료) {
		this.대결종료 = 대결종료;
	}


}
