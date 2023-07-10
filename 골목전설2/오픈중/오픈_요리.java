package 오픈중;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.w3c.dom.ranges.RangeException;

import A_시나리오.시나리오;
import 상권.아이템들.식재료들.식재료;
import 상권.아이템들.주방도구들.팬류들.A_팬들;
import 상권.아이템들.주방도구들.화구들.A_화구;
import 오픈중.요리모음.메뉴;
import 오픈중.요리모음.요리;
import 캐릭터들.손님상속.손님;
import 캐릭터들.직원분들.직원;
import 캐릭터들.집안.주인공;

public class 오픈_요리 extends 오픈{

	오픈_요리(){}
	
	오픈_요리(Map<String, Object> 시작_변수){
		
		영업일수 = (int)시작_변수.get("영업일수");
		영업시간 = (int)시작_변수.get("영업시간");
		알바유무 = (boolean)시작_변수.get("알바유무");
		요리시간 = (int)시작_변수.get("요리시간");
		손님_리스트 = (List<String>)시작_변수.get("손님_리스트");
		받은_메뉴 = (List<요리>)시작_변수.get("받은_메뉴");
		현재_총_손님 = (Map<String, 손님>)시작_변수.get("현재_총_손님");
		
		요청사항_성공_수 = 0;
		추가주문_성공_수 = 0;
	}

	
	@Override
	protected void 요리_시작(주인공 주인공) {

		요리시작_기본(주인공);
		요리_중(주인공);
		서빙_시작(주인공);
		
	}
	@Override
	protected void 요리_시작_대결(주인공 주인공) {
		
		요리시작_기본(주인공);
		시나리오.타이머(주인공, 5);
		요리_중(주인공);
		
		서빙_시작_대결(주인공);
		
	}
	private void 요리시작_기본(주인공 주인공) {
		
		요리된_메뉴 = new LinkedList<요리>();
		
		요리_시작_시나리오();
		
	}
	private void 요리_시작_시나리오() {
		
		시나리오.출력("\n요리를 시작합니다.");
		시나리오.엔터();
	
	}
	private void 요리_중(주인공 주인공) {
	
		요리용_주문지();	
		요리하기(주인공);
		시나리오.출력("요리완료.");
	
	}
	int 요리선택;
	int 재시작 = 0;
	private void 요리하기(주인공 주인공) {
		
		실패횟수 = 0;
		while(요리시간>0) {
			
			//추가주문_이벤트들(주인공);
			
			try{
				
				if(주인공.get타임어택실패()) {throw new IllegalAccessException();}
				
				요리 = 할_요리_선택();
				
				
				남은_요리시간_계산(주인공);
				
				
				if(요리_체크(주인공)) {
				
					//추가주문_성공여부_체크(요리);
					
					완성요리_요리된_메뉴_추가();
					완성요리_받은_메뉴에서_제거(요리선택);
					
					if(요리_중_종료()) {
						break;
					}
					
					if(주인공.get타임어택실패()) {throw new IllegalAccessException();}
					
					요리용_주문지();
				}else if(실패횟수 < 3) {
					요리실패_후_재시도(주인공);
				}else {
					요리실패_시나리오(주인공);
				}
				
			}catch(IllegalAccessException e) {
				for(int i = 0; i < 10; i++) {
					System.out.println("");
				}
				시나리오.점점점("시간이 만료 되었습니다.");
				주인공.미션보드.정보.set대결종료(true);
				
				
				try {
					Thread.sleep(1000);
					주인공.미션보드.set진행중_미션(null);
					주인공.set타임어택실패(false);
					시나리오.출력("시작화면으로 이동합니다");
					시나리오.엔터();
					시나리오.영업선택(주인공);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}catch(Exception e){
				
				시나리오.출력("다시 선택해 주세요.");
				시나리오.엔터();	
				재시작 = 재시작 + 1;
				
				if(주인공.미션보드.get대결중()) {
					요리_중(주인공);
					서빙_시작_대결(주인공);
				}else {
					요리_시작(주인공); 
				}
			
			}finally {
				
			}
		}
	}
	private void 추가주문_이벤트들(주인공 주인공) {
		
		if(Math.random() < 1) {
			추가주문(주인공);
		}
		
		if(Math.random() > 0.95) {
			시나리오.출력("특별주문 됨.");
		}
		
		if(Math.random() > 0.95) {
			시나리오.출력("중식 주문 됨.");
		}
		
	}
	int 추가주문_횟수 = 0;
	private void 추가주문(주인공 주인공) {
		
		boolean 추가주문_조건 =  받은_메뉴.size() == 1 
							? (추가주문_횟수 < 1 ? true : false) : false;
		
		if(추가주문_조건) {
			시나리오.출력("added New");
			오픈_고객응대 추가_응대 = new 오픈_고객응대();
			추가_응대.손님_수 = 1;
			추가_응대.손님_리스트 = 손님_리스트;
			추가_응대.받은_메뉴 = 받은_메뉴; 
			추가_응대.현재_총_손님 = 현재_총_손님;
			추가_응대.메뉴 = new 메뉴(주인공);
			추가_응대.주문();
			추가_응대.손님.추가주문_여부 = true;
			
			손님_리스트 = 추가_응대.손님_리스트;
			받은_메뉴 = 추가_응대.받은_메뉴;
			현재_총_손님 = 추가_응대.현재_총_손님;
			
			추가주문_횟수 = 추가주문_횟수+1;
		}
		
	}
	private 요리 할_요리_선택() {
		
		시나리오.한줄("요리할 메뉴 선택: ");
		요리선택 = 시나리오.선택();
		
		return 받은_메뉴.get(요리선택-1);
		
	}
	private boolean 요리_체크(주인공 주인공) {
		
		return (요리_가능_체크(주인공) 
					&& 레시피_체크(주인공) 
					&& 요청사항_체크(주인공));
		
	}
	private int 남은_요리시간_계산(주인공 주인공) {
		
		요리시간 = 요리시간 - ((int)요리.get조리시간() - (int)아이템_사용(주인공));
		return 요리시간; 
		
	}
	private int 아이템_사용(주인공 주인공) {
		
		return ((int)팬_사용(주인공) + (int)화구_사용(주인공));
		
	}
	private int 팬_사용(주인공 주인공) {
		
		A_팬들 팬 = 주인공.get팬();
		return 주인공.팬_여부_리턴() ? 팬.get효율성_도움() : 0; 
		
	}
	private int 화구_사용(주인공 주인공) {
		
		A_화구 화구 = 주인공.get화구();
		return 주인공.화구_여부_리턴() ? 화구.get효율성_도움() : 0;
		
	}
	private void 완성요리_요리된_메뉴_추가() {
		
		요리된_메뉴.add(요리);	
	}
	private void 완성요리_받은_메뉴에서_제거(int 요리선택) {
		
		받은_메뉴.remove(요리선택-1);
	}
	private boolean 요리_중_종료() {
		
		return (받은_메뉴.size() <= 0 ? true : false);
	}
	
	//보기
	private void 요리용_주문지() {
		
		String 주문지 = "======================================\n"
					+ "     받은 메뉴 리스트\n";
		Collections.shuffle(받은_메뉴);
		for(int i=0; i<받은_메뉴.
				size();i++) {
			주문지 = 주문지 + (i+1)+". "+ 받은_메뉴.get(i).get메뉴명() + "   \t요청사항: "+
					받은_메뉴.get(i).get추가주문() +"\n"; }
			주문지 = 주문지 + "\n남은 요리 시간: " + 요리시간 	+ 	" 분"
					     + "\n남은 영업 시간: " + 영업시간/60 + " 시간";	
			시나리오.출력(주문지);
			
	}
	
	
	
	private boolean 요리_가능_체크(주인공 주인공) {
		
		List<String> 특기체크 = new ArrayList<String> ();
		특기체크.add(주인공.get특기());
		
		for(직원 직원 : 주인공.get보유직원()) {
			특기체크.add(직원.get특기());
		}
		
		boolean 체크결과 = (특기체크.contains(요리.get메뉴타입()) ? true : false);
		
		return 체크결과; 
	}
	@SuppressWarnings("static-access")
	boolean 레시피_체크(주인공 주인공) {
		
		List<String> 레시피체크 = new ArrayList<String> ();
		레시피체크.add(주인공.get특기());
		for(식재료 식재료 : 주인공.get보유_식재료()) {레시피체크.add(식재료.get식재료_이름());}
		boolean 체크결과 = 
			레시피체크.containsAll(요리.get레시피()) ? true : false;
		return 체크결과;
		
	}
	@SuppressWarnings("static-access")
	boolean 요청사항_체크(주인공 주인공) {
		
		if(요리.get추가주문().equals("없음")) {return true;}
		시나리오.첫줄("요청사항 처리 중.");
		시나리오.출력("1.반찬추가     2.조리추가   \n");
		시나리오.한줄("선택해주세요: ");
		int 추가주문_선택 = 시나리오.선택();
		
		String 추가된_조리 = "";
		switch(추가주문_선택) {
			case 1: 추가된_조리 = 재료추가(주인공); break;
			case 2: 추가된_조리 = 조리추가(주인공); break;
		}
		if(요리.get추가주문().equals("없음")){
			return true;
		}else if(추가된_조리.equals(요리.get추가주문())){
			요청사항_성공_수 = 요청사항_성공_수 + 1;
			시나리오.출력("\n요청사항 완료"); 
			시나리오.엔터();			     
			return true;
		}
		else {return false;}
	
	}//여기서 추가주문 처리 링크로가서 처리. 
	@SuppressWarnings("static-access")	
	private String 재료추가(주인공 주인공) {
		
		return "반찬추가";
		
	}
	@SuppressWarnings("static-access")
	private	String 조리추가(주인공 주인공) {
		
		시나리오.출력("추가 조리를 선택해 주세요.");
		시나리오.출력("1.곱배기     2. 맵게     3.포장     ");
		시나리오.한줄("선택해주세요: ");
		int 조리추가_선택 = 시나리오.선택();
		String 조리추가 = ""; 
		switch(조리추가_선택) {
		case 1: 조리추가 = "곱배기";	 break;
		case 2: 조리추가 = "맵게";		 break;
		case 3: 조리추가 = "포장";		 break;}
		return 조리추가;
		
	}
	@SuppressWarnings("static-access")
	private String 스킬(주인공 주인공) {
		return "스킬";
	}
	

	
	
	
	//Catch Part
	private void 요리실패_후_재시도(주인공 주인공) {
		
		실패횟수 = 실패횟수+1;
		시나리오.출력("실패횟수: "+ 실패횟수);
		if(주인공.미션보드.get대결중()) {
			요리_중(주인공);
			서빙_시작_대결(주인공);
		}else {
			요리_시작(주인공); 
		}
	}
	private void 요리실패_시나리오(주인공 주인공) {
		
		시나리오.출력("요리가 불가능 합니다.");
		시나리오.출력("평판이 하락 하였습니다.");
		시나리오.엔터();	
		
		if(주인공.미션보드.get대결중()) {
			시나리오.출력("여기서 대결 처리");
		}else {
			오픈(주인공);
		}
	}
	
	
	
	private Map<String, Object> 서빙_사용_변수() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("요리된_메뉴", 요리된_메뉴);
		return map;
	}
	

	
	
}
