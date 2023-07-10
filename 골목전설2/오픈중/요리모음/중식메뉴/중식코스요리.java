package 오픈중.요리모음.중식메뉴;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import 상권.아이템들.식재료들.중식재료들.중식_고급해물;
import 상권.아이템들.식재료들.중식재료들.중식_고추;
import 상권.아이템들.식재료들.중식재료들.중식_고추기름;
import 상권.아이템들.식재료들.중식재료들.중식_기본_재료;
import 상권.아이템들.식재료들.중식재료들.중식_닭고기;
import 상권.아이템들.식재료들.중식재료들.중식_돼지고기;
import 상권.아이템들.식재료들.중식재료들.중식_빵;
import 상권.아이템들.식재료들.중식재료들.중식_오리;
import 상권.아이템들.식재료들.중식재료들.중식_짜장소스;
import 상권.아이템들.식재료들.중식재료들.중식_짬뽕국물;
import 상권.아이템들.식재료들.중식재료들.중식_탕수육소스;
import 상권.아이템들.식재료들.중식재료들.중식_해물;

public class 중식코스요리 extends A_중식 {
	
	String 메뉴명 = "중식코스요리";
	int 시간 = 10;
	List<String> 레시피 = new ArrayList<String>();

	public 중식코스요리(String 특기) {
		
		레시피.addAll(Arrays.asList(
					
					new 중식_기본_재료().get식재료_이름(), 
					new 중식_해물().get식재료_이름(), 
					new 중식_고급해물().get식재료_이름(), 
					new 중식_오리().get식재료_이름(), 
					new 중식_짜장소스().get식재료_이름(), 
					new 중식_짬뽕국물().get식재료_이름(), 
					new 중식_탕수육소스().get식재료_이름(), 
					new 중식_고추기름().get식재료_이름(), 
					new 중식_고추().get식재료_이름(), 
					new 중식_빵().get식재료_이름(), 
					new 중식_닭고기().get식재료_이름(), 
					new 중식_돼지고기().get식재료_이름()
					
					));
		if(super.요리자격(특기)) {요리세팅(메뉴명, 시간, 레시피);}}
	

	@Override
	public void 요리세팅(String 메뉴명, int 조리시간, List<String> 레시피) {
		super.요리세팅(메뉴명, 조리시간, 레시피);
	}

}
