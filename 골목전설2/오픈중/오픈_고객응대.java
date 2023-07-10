package 오픈중;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import A_시나리오.시나리오;
import 오픈중.요리모음.메뉴;
import 오픈중.요리모음.요리;
import 캐릭터들.손님상속.손님;
import 캐릭터들.집안.주인공;

public class 오픈_고객응대 extends 오픈{
	오픈 오픈; 
	JOptionPane 팝업;
	
	오픈_고객응대(){}

	오픈_고객응대(Map<String, Object> 시작_변수){
		
		
		영업일수 = (int)시작_변수.get("영업일수");
		영업시간 = (int)시작_변수.get("영업시간");
		알바유무 = (boolean)시작_변수.get("알바유무");
		손님_수 = (int)시작_변수.get("손님_수");
		요리시간 = (int)시작_변수.get("요리시간");
	
	}
	
	@Override
	protected void 홀_체크(주인공 주인공) {
		
		홀체크_실패_오픈복귀(주인공);
		고객응대(주인공);
	}
	private void 홀체크_실패_오픈복귀(주인공 주인공) {
		
		if(!알바유무) {
			시나리오.출력("알바가 없다면 고객을 직접 응대해 주세요.");
			시나리오.엔터();	
			
			오픈(주인공);
		}
	}
	
	@Override
	public void 고객응대(주인공 주인공) {
		
		고객응대_기본(주인공);
	
		요리_시작(주인공);
	}
	@Override 
	public void 고객응대_대결(주인공 주인공) {
		
		고객응대_기본(주인공);
		
		요리_시작_대결(주인공);
		
	}
	private void 고객응대_기본(주인공 주인공) {
		
		손님_리스트 = new ArrayList<String>();
		현재_총_손님 = new HashMap<String, 손님>();
		
		메뉴 = new 메뉴(주인공);		
		받은_메뉴 = new LinkedList<요리>();
		
		손님_수_계산(주인공);
		영업시간_차감();
		알바도움_반영_요리시간(주인공);
		
		주문();
		주문확인();
	
		
	}
	private void 손님_수_계산(주인공 주인공) {
		
		int 알바_있으면_손님_추가 = 주인공.홀직원_여부() ? 2 : 0; 
		int 화구_있으면_손님_추가 = 주인공.화구_여부_리턴() ? 5 : 0; 
		
		손님_수 = 손님_수 + 알바_있으면_손님_추가 + 화구_있으면_손님_추가;
	}
	private void 영업시간_차감() {
		
		영업시간 = 영업시간-60;	
	}
	private void 알바도움_반영_요리시간(주인공 주인공) {
		
		int 알바도움  = 	(주인공.홀직원_여부()) ? 0 : 16;
		요리시간 = 요리시간 + 60 - 알바도움;
	}
	
	손님 손님;
	protected void 주문() {
		
		for(int i = 0; i < 손님_수; i++) {
			
			손님 = new 손님(i);	
			손님.주문(메뉴);
			
			손님_리스트.add(손님.get손님성함());
			받은_메뉴.add(손님.get주문내역());
			현재_총_손님.put(손님.get손님성함(), 손님);
		}
	}
	
	private void 주문확인() {
		주문지_전체보기();
		팝업 = new JOptionPane(주문지_전체,JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = 팝업.createDialog(null, "Go");
		dialog.setAlwaysOnTop(true);
		dialog.setModal(false);
		dialog.setVisible(true);
		//JOptionPane.showMessageDialog(팝업, 주문지_전체);
	}
	private void 주문지_전체보기() {
		
		주문지_전체 = "주문 내역\n";
		주문_리스트();
	}
	private void 주문_리스트() {
		
		int index = 0;
		for(Entry<String, 손님> entry : 현재_총_손님.entrySet()) {
			
			index++;
			String 메뉴명 = entry.getValue().get주문내역().get메뉴명();
			int 메뉴명_길이 = 메뉴명.length();
			int spaceCnt = 16 - (메뉴명_길이+entry.getKey().length()+String.valueOf(index).length());
			String space = "";
			for(int i = 0; i < spaceCnt; i++) {
				space = space + "  ";
			}
			if(메뉴명_길이%2 == 0) {space = space + " ";}
			
			
			주문지_전체 = 주문지_전체 + "\n"+ index + ". "
					+ entry.getKey() + " : " 
					+ 메뉴명
					+ space + "요청사항("+ entry.getValue().get추가주문내역() +")";
		}
	
	}
	

	
	
	
	
	
	
	

}
