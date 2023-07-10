package 오픈중.요리모음.중식메뉴;

import 오픈중.요리모음.요리;

public class A_중식 extends 요리{


	
	String 메뉴타입 = "중식";
	
	public A_중식() 	{super.메뉴타입 = 메뉴타입;}
	

	public void hi() {
		System.out.println(super.조리시간);
		System.out.println(super.레시피);
		System.out.println(super.메뉴타입);
	}
	

	
	
}
