package 오픈중.요리모음.중식메뉴;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import 상권.아이템들.식재료들.중식재료들.중식_기본_재료;
import 상권.아이템들.식재료들.중식재료들.중식_짜장소스;

public class 짜장면 extends A_중식{

	String 메뉴명 = "짜장면";
	int 시간 = 10;
	List<String> 레시피 = new ArrayList<String>();

	public 짜장면(String 특기) {
		
		레시피.addAll(Arrays.asList(
					
					new 중식_기본_재료().get식재료_이름(), 
					new 중식_짜장소스().get식재료_이름()
					
					));
		if(super.요리자격(특기)) {요리세팅(메뉴명, 시간, 레시피);}}
	

	@Override
	public void 요리세팅(String 메뉴명, int 조리시간, List<String> 레시피) {
		super.요리세팅(메뉴명, 조리시간, 레시피);
	}

	public void hi() {
		System.out.println(super.조리시간);
		System.out.println(super.레시피);
		System.out.println(super.메뉴타입);
	}
}