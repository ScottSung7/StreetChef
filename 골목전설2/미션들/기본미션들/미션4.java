package 미션들.기본미션들;

import 미션들.미션보드_정보;
import 상권.아이템들.식재료들.한식재료들.한식_간장;
import 상권.아이템들.식재료들.한식재료들.한식_소고기;
import 캐릭터들.집안.주인공;

public class 미션4 extends 기본미션{

	public 미션4(){
		
		미션번호 = "B4";
		미션이름 = "기본미션 4";
		미션내용 = "새 장비를 구입하세요.";
	}
	
	
	@Override
	public boolean 미션체크(미션보드_정보 정보) {
		
		//성공여부 = (정보.팬_여부 ? true 
		//		: 정보.화구_여부 ? true : false);
		
		성공여부 = true;
		
		return 성공여부; 
	}
	@Override
	public void 미션_보상(주인공 주인공) {
		
		주인공.add미션_성공수(성공여부 ? 1 : 0);
		
		if(주인공.get특기().equals(특기_한식)) {
			
			주인공.add보유_식재료(new 한식_소고기());
			주인공.add보유_식재료(new 한식_간장());
		}
		
	}
	
	
}
