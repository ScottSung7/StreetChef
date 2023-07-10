package 미션들.기본미션들;

import 미션들.미션보드_정보;
import 상권.아이템들.식재료들.중식재료들.중식_닭고기;
import 상권.아이템들.식재료들.한식재료들.한식_돌솥;
import 상권.아이템들.식재료들.한식재료들.한식_야채;
import 캐릭터들.집안.주인공;

public class 미션3 extends 기본미션{
	
	
	public 미션3(){
		
		미션번호 = "B3";
		미션이름 = "기본미션 3";
		미션내용 = "요청 사항이 있는 주문을 20개 클리어 하세요.";
		
		목표_성공_수 = 20; 
	}
	
	@Override
	public boolean 미션체크(미션보드_정보 정보) {
	
		//성공여부 = (정보.요청사항_성공_수 >= 목표_성공_수 ? true : false);
		성공여부 = true;
		
		return 성공여부; 
	}
	@Override
	public void 미션_보상(주인공 주인공) {
		
		주인공.add미션_성공수(성공여부 ? 1 : 0);
		
		if(주인공.get특기().equals(특기_한식)) {
			
			주인공.add보유_식재료(new 한식_돌솥());
			주인공.add보유_식재료(new 한식_야채());
			
		}else if(주인공.get특기().equals(특기_중식)){
			주인공.add보유_식재료(new 중식_닭고기());
		}
		
		
	}
	
	
}
