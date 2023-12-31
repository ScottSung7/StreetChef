package 미션들.일반미션들;

import 미션들.미션보드_정보;
import 상권.아이템들.식재료들.중식재료들.중식_고급해물;
import 상권.아이템들.식재료들.중식재료들.중식_고추;
import 상권.아이템들.식재료들.중식재료들.중식_고추기름;
import 상권.아이템들.식재료들.중식재료들.중식_기본_재료;
import 상권.아이템들.식재료들.중식재료들.중식_닭고기;
import 상권.아이템들.식재료들.중식재료들.중식_돼지고기;
import 상권.아이템들.식재료들.중식재료들.중식_마라소스;
import 상권.아이템들.식재료들.중식재료들.중식_빵;
import 상권.아이템들.식재료들.중식재료들.중식_오리;
import 상권.아이템들.식재료들.중식재료들.중식_중국당면;
import 상권.아이템들.식재료들.중식재료들.중식_짜장소스;
import 상권.아이템들.식재료들.중식재료들.중식_짬뽕국물;
import 상권.아이템들.식재료들.중식재료들.중식_탕수육소스;
import 상권.아이템들.식재료들.중식재료들.중식_해물;
import 상권.아이템들.식재료들.한식재료들.한식_간장;
import 상권.아이템들.식재료들.한식재료들.한식_고급야채;
import 상권.아이템들.식재료들.한식재료들.한식_고추장;
import 상권.아이템들.식재료들.한식재료들.한식_그릴;
import 상권.아이템들.식재료들.한식재료들.한식_기본_재료;
import 상권.아이템들.식재료들.한식재료들.한식_김치;
import 상권.아이템들.식재료들.한식재료들.한식_돌솥;
import 상권.아이템들.식재료들.한식재료들.한식_돼지고기;
import 상권.아이템들.식재료들.한식재료들.한식_된장;
import 상권.아이템들.식재료들.한식재료들.한식_두부;
import 상권.아이템들.식재료들.한식재료들.한식_떡;
import 상권.아이템들.식재료들.한식재료들.한식_소고기;
import 상권.아이템들.식재료들.한식재료들.한식_순두부;
import 상권.아이템들.식재료들.한식재료들.한식_야채;
import 캐릭터들.집안.주인공;

public class 미션D extends 일반미션{
	
	
	public 미션D(){
		
		미션번호 = "A4"; 
		미션이름 = "일반 미션 4";; 
		미션내용 = "평점 5.0점을 달성하세요.";
	}
	@Override
	public boolean 미션체크(미션보드_정보 정보) {
		
		this.정보 = 정보;
		if(정보.평점 == 5.0f) {
			성공여부 = true;
		}
		
		성공여부 = true;
		
		return 성공여부;
	}
	@Override
	public void 미션_보상(주인공 주인공) {
		
		//보상.
		주인공.add미션_성공수(성공여부 ? 1 : 0);
		
		if(주인공.get특기().equals(특기_한식)) {
			
			주인공.add보유_식재료(new 중식_기본_재료());
			주인공.add보유_식재료(new 중식_짜장소스());
			주인공.add보유_식재료(new 중식_해물());
			주인공.add보유_식재료(new 중식_짬뽕국물());
			주인공.add보유_식재료(new 중식_돼지고기());
			주인공.add보유_식재료(new 중식_탕수육소스());
			주인공.add보유_식재료(new 중식_고추기름());
			주인공.add보유_식재료(new 중식_고추());
			주인공.add보유_식재료(new 중식_빵());
			주인공.add보유_식재료(new 중식_닭고기());
			주인공.add보유_식재료(new 중식_고급해물());
			주인공.add보유_식재료(new 중식_마라소스());
			주인공.add보유_식재료(new 중식_중국당면());
			주인공.add보유_식재료(new 중식_오리());
			
		}else if(주인공.get특기().equals(특기_중식)){
			
			주인공.add보유_식재료(new 한식_기본_재료());
			주인공.add보유_식재료(new 한식_김치());
			주인공.add보유_식재료(new 한식_된장());
			주인공.add보유_식재료(new 한식_고추장());
			주인공.add보유_식재료(new 한식_돼지고기());
			주인공.add보유_식재료(new 한식_떡());
			주인공.add보유_식재료(new 한식_돌솥());
			주인공.add보유_식재료(new 한식_야채());
			주인공.add보유_식재료(new 한식_소고기());
			주인공.add보유_식재료(new 한식_간장());
			주인공.add보유_식재료(new 한식_두부());
			주인공.add보유_식재료(new 한식_순두부());
			주인공.add보유_식재료(new 한식_그릴());
			주인공.add보유_식재료(new 한식_고급야채());
			
		}
		
	}

}
