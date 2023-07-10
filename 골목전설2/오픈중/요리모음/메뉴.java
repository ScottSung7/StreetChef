package 오픈중.요리모음;

import java.util.Random;

import 오픈중.요리모음.중식메뉴.A_중식;
import 오픈중.요리모음.중식메뉴.고추잡채;
import 오픈중.요리모음.중식메뉴.깐풍기;
import 오픈중.요리모음.중식메뉴.마라샹궈;
import 오픈중.요리모음.중식메뉴.북경오리;
import 오픈중.요리모음.중식메뉴.중식코스요리;
import 오픈중.요리모음.중식메뉴.짜장면;
import 오픈중.요리모음.중식메뉴.짬뽕;
import 오픈중.요리모음.중식메뉴.탕수육;
import 오픈중.요리모음.중식메뉴.팔보채;
import 오픈중.요리모음.한식메뉴.A_한식;
import 오픈중.요리모음.한식메뉴.구절판;
import 오픈중.요리모음.한식메뉴.김치찌게;
import 오픈중.요리모음.한식메뉴.돌솥비빔밥;
import 오픈중.요리모음.한식메뉴.된장찌게;
import 오픈중.요리모음.한식메뉴.두부김치;
import 오픈중.요리모음.한식메뉴.북촌순두부;
import 오픈중.요리모음.한식메뉴.삼겹살;
import 오픈중.요리모음.한식메뉴.언양불고기;
import 오픈중.요리모음.한식메뉴.이십첩밥상;
import 오픈중.요리모음.한식메뉴.제육볶음;
import 오픈중.요리모음.한식메뉴.즉석떡볶이;
import 캐릭터들.집안.주인공;

public class 메뉴 {
	
	주인공 주인공;
	String 특기;
	요리 요리;
	//한식
	A_한식 한식 = new A_한식();
	A_중식 중식 = new A_중식();
	
	int 메뉴_수 = 0;
	int 한식_메뉴수 = 2;
	int 중식_메뉴수 = 2;
	int 메뉴_번호_조정;
	int 중식_메뉴_번호_조정 = 11;
	
	메뉴(){}
	
	public 메뉴(주인공 주인공) {
		
		this.주인공 = 주인공;
		특기 = 주인공.get특기();
		
		if(특기.equals(한식.get메뉴타입())){
			
			메뉴_수 = 한식_메뉴수 + 주인공.get미션_성공수();
			if(주인공.get요리사여부() && 주인공.get미션_성공수() > 8) {
				메뉴_수 = 19;
			}
			
		}else if(특기 == 중식.get메뉴타입()) {
			
			메뉴_수 = 중식_메뉴수 + 주인공.get미션_성공수();
			메뉴_번호_조정 = 중식_메뉴_번호_조정;
			if(주인공.get요리사여부() && 주인공.get미션_성공수() > 8) {
				메뉴_수 = 19;
				메뉴_번호_조정 = 0;
			}
			
		}
		//중식이면 수:8 선택:+20 //한식이면 수:10
	}
	public 요리 주문() {
		
		Random random = new Random();
		int 메뉴_번호 = random.nextInt(메뉴_수); 
		메뉴_번호 = 메뉴_번호 + 메뉴_번호_조정;
		
		요리선택(메뉴_번호);
		return 요리;
	}//0~20 한식 // 중식 = +20
	public void 요리선택(int num) {
		switch(num) {
		case 0: 요리 = new 된장찌게(특기); 		break;
		case 1: 요리 = new 김치찌게(특기);		break;
		case 2: 요리 = new 제육볶음(특기); 		break;
		case 3: 요리 = new 즉석떡볶이(특기); 		break;
		case 4: 요리 = new 돌솥비빔밥(특기); 		break;
		case 5: 요리 = new 언양불고기(특기); 		break;
		case 6: 요리 = new 두부김치(특기); 		break;
		case 7: 요리 = new 북촌순두부(특기); 		break;
		case 8: 요리 = new 삼겹살(특기); 		break;
		case 9: 요리 = new 구절판(특기); 		break;
		case 10: 요리 = new 이십첩밥상(특기); 	break;
		case 11: 요리 = new 짜장면(특기); 		break;
		case 12: 요리 = new 짬뽕(특기); 		break;
		case 13: 요리 = new 탕수육(특기); 		break;
		case 14: 요리 = new 고추잡채(특기); 		break;
		case 15: 요리 = new 깐풍기(특기); 		break;
		case 16: 요리 = new 팔보채(특기); 		break;
		case 17: 요리 = new 마라샹궈(특기); 		break;
		case 18: 요리 = new 북경오리(특기); 		break;
		case 19: 요리 = new 중식코스요리(특기); 	break;
		
		}
	}
	public void 요리조회() {
		요리.hi();
	}
	
	
	
	/*	public void 요리제작(int num) {
	switch(num) {
	case 0: 된장찌게 = new 된장찌게(특기); break;
	case 1: 김치찌게 = new 김치찌게(특기); break;
	case 2: 짜장면 = new 짜장면(특기); break;
	}
}*/
	
	
}
