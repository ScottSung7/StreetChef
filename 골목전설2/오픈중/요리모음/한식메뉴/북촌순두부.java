package 오픈중.요리모음.한식메뉴;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import 상권.아이템들.식재료들.한식재료들.한식_고추장;
import 상권.아이템들.식재료들.한식재료들.한식_기본_재료;
import 상권.아이템들.식재료들.한식재료들.한식_김치;
import 상권.아이템들.식재료들.한식재료들.한식_순두부;

public class 북촌순두부 extends A_한식{
	
	String 메뉴명 = "북촌순두부";
	int 시간 = 10;
	List<String> 레시피 = new ArrayList<String>();
	
	public 북촌순두부(String 특기) {
		레시피.addAll(Arrays.asList(
				new 한식_기본_재료().get식재료_이름(), 
				new 한식_김치().get식재료_이름(),
				new 한식_고추장().get식재료_이름(),
				new 한식_순두부().get식재료_이름()
				));
		if(super.요리자격(특기)) {
			요리세팅(메뉴명, 시간, 레시피);
		}
	}
}
