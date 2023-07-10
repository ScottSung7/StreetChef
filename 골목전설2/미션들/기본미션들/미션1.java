package 미션들.기본미션들;

import A_시나리오.시나리오;
import 미션들.미션보드_정보;
import 상권.아이템들.식재료들.중식재료들.중식_돼지고기;
import 상권.아이템들.식재료들.중식재료들.중식_탕수육소스;
import 상권.아이템들.식재료들.한식재료들.한식_고추장;
import 상권.아이템들.식재료들.한식재료들.한식_돼지고기;
import 캐릭터들.집안.주인공;

public class 미션1 extends 기본미션{
	
	
	
	public 미션1(){
		
		미션번호 = "B1";
		미션이름 = "기본미션 1"; 
		미션내용 = "요리를 해서 서빙 성공을 10번 완료하세요.";
		
		목표_성공_수 = 10;
	}
	@Override
	public boolean 미션체크(미션보드_정보 정보) {
		
		this.정보 = 정보;
		성공여부 = (정보.서빙_성공_수 >= 목표_성공_수 ? true : false);
		//성공여부 = true;
		return 성공여부;
	}
	@Override
	public void 미션_보상(주인공 주인공) {
		
		주인공.add미션_성공수(성공여부 ? 1 : 0);
		
		if(주인공.get특기().equals(특기_한식)) {
			
			주인공.add보유_식재료(new 한식_고추장());
			주인공.add보유_식재료(new 한식_돼지고기());
			
		}else if(주인공.get특기().equals(특기_중식)){
			주인공.add보유_식재료(new 중식_돼지고기());
			주인공.add보유_식재료(new 중식_탕수육소스());
		}
		
		
	}
	public void 진행상태() {
		시나리오.첫줄("미션1 진행 중");
	}
	
	

	private void 상태출력() {
		switch(정보.서빙_성공_수 >= 목표_성공_수 ? 0 : 1) {
		case 0: System.out.println("완료하지 않음.");
		case 1: System.out.println("클리어");
		}
	}

}
