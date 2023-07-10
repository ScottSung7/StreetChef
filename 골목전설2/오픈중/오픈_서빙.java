package 오픈중;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import A_시나리오.시나리오;
import 오픈중.요리모음.요리;
import 캐릭터들.손님상속.손님;
import 캐릭터들.집안.주인공;

public class 오픈_서빙 extends 오픈{
	

	오픈_서빙(){}
	
	오픈_서빙(Map<String, Object> 시작_변수){
		
		영업일수 = (int)시작_변수.get("영업일수");
		영업시간 = (int)시작_변수.get("영업시간");
		알바유무 = (boolean)시작_변수.get("알바유무");
		요리시간 = (int)시작_변수.get("요리시간");
		손님_리스트 = (List<String>)시작_변수.get("손님_리스트");
		받은_메뉴 = (List<요리>)시작_변수.get("받은_메뉴");
		현재_총_손님 = (Map<String, 손님>)시작_변수.get("현재_총_손님");
		요리된_메뉴 = (List<요리>) 시작_변수.get("요리된_메뉴"); 
		
		서빙_성공_수 = 0;
	}
	
	@Override
	protected void 서빙_시작(주인공 주인공) {
		
		서빙(주인공);
		다음타임_시작(주인공);
	}
	@Override
	protected void 서빙_시작_대결(주인공 주인공) {
		
		서빙(주인공);
		다음타임_시작_대결(주인공);
	}
	@SuppressWarnings("static-access")
	private void 서빙(주인공 주인공) {
		시나리오.첫줄("서빙을 시작합니다.");
		시나리오.엔터();
		while(요리된_메뉴.size() > 0) {
			
			try {
				if(주인공.get타임어택실패()) {throw new IllegalAccessException();}
				
				AtomicInteger index2 = new AtomicInteger();
				int 선택된_서빙메뉴_번호 = 서빙_요리된_메뉴_선택();
				if(주인공.get타임어택실패()) {throw new IllegalAccessException();}
				
				int 선택된_손님_번호 = 서빙_손님_선택();
				if(주인공.get타임어택실패()) {throw new IllegalAccessException();}
				
				요리 선택된_서빙메뉴 = 요리된_메뉴.get(선택된_서빙메뉴_번호-1);
				손님 서빙중_손님 = 현재_총_손님.get(손님_리스트.get(선택된_손님_번호-1));
				
				if(서빙중_손님.후기(선택된_서빙메뉴,  주인공)) {
					손님_리스트.remove(선택된_손님_번호-1);
					서빙_성공_수 = 서빙_성공_수 + 1; 
					서빙_성공_수_대결 = 서빙_성공_수_대결 + 1;
					//추가주문_성공여부_체크(서빙중_손님);
					시나리오.첫줄("서빙 성공");
				}else {
					시나리오.출력("서빙 실패");
					시나리오.출력("평판이 하락 하였습니다.");}
					요리된_메뉴.remove(선택된_서빙메뉴_번호-1);
					시나리오.출력("\n\n남은 손님: "+ 손님_리스트);
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
			}
				
		}
		
	
	}
	//받은_메뉴와 상관없이 요리된_메뉴에서 인덱스 생성해서 손님의 주문과 매치. 
	@SuppressWarnings("static-access")
	private int 서빙_요리된_메뉴_선택() {
		시나리오.출력("=============");
		시나리오.출력("  요리된 메뉴");
		AtomicInteger index1 = new AtomicInteger();
		요리된_메뉴.forEach(value 
				-> {index1.getAndIncrement(); 
				시나리오.출력(index1+". "+ value.get메뉴명());
			});
		
		시나리오.한줄("\n서빙할 메뉴 선택: ");
		int 선택된_서빙메뉴_번호 = 시나리오.선택();
		시나리오.출력("선택된 메뉴: "+ 
		요리된_메뉴.get(선택된_서빙메뉴_번호-1).get메뉴명()+"\n");
		return 선택된_서빙메뉴_번호;
	}
	@SuppressWarnings("static-access")
	private int 서빙_손님_선택() {
		
		시나리오.출력("  손님 리스트");
		AtomicInteger index2 = new AtomicInteger();
		
		손님_리스트.forEach(value 
			-> {index2.getAndIncrement(); 
			System.out.println(index2+". "+ value);
		});
		
		시나리오.한줄("서빙할 손님 선택: ");
		int 선택된_손님_번호 = 시나리오.선택();
		String 선택된_손님 = 손님_리스트.get(선택된_손님_번호-1);
		시나리오.출력("선택된 손님: "+ 선택된_손님);
		return 선택된_손님_번호;
	}
	private void 추가주문_성공여부_체크(손님 손님) {
		
		
		if(손님.추가주문_여부 = true) {
			System.out.println("추가주문 손님이네~");
		}
	}
	

}
