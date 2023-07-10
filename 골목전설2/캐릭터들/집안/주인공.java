package 캐릭터들.집안;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import A_시나리오.시나리오;
import 미션들.미션보드;
import 상권.아이템들.식재료들.식재료;
import 상권.아이템들.주방도구들.팬류들.A_팬들;
import 상권.아이템들.주방도구들.화구들.A_화구;
import 오픈중.오픈;
import 캐릭터들.직원분들.직원;
import 캐릭터들.직원분들.홀직원들.A_홀직원;
import 캐릭터들.집안.중식대가집안.중식대가;
import 캐릭터들.집안.한식대가집안.한식대가;
public class 주인공 extends 캐릭터{
	
	//시나리오 시나리오 = new 시나리오();
	protected String 이름 = "마스터";
	protected String 특기 ="한식";
	protected int 돈 = 0;
	protected int 평판; 
	protected int 주문수 = 1; //350+(500x)/(1+x) = 499  149/49
	protected String 상대집안특기= get특기() == "한식" ? "중식": "한식"; 
	protected boolean 요리사여부;
	
	protected List<식재료> 보유_식재료 = new ArrayList();
	protected List<직원> 보유직원 = new ArrayList<직원>();
	A_팬들 팬; 		A_화구 화구;

	public 미션보드 미션보드 = new 미션보드();
	public 오픈 오픈 = new 오픈();
	int 미션_성공수 = 0;
	boolean 타임어택완료 = false;
	boolean 타임어택실패 = false;
	
	
	public boolean 대기중 = false;
	DecimalFormat 숫자_포맷 = new DecimalFormat("###,###");
	AtomicInteger index;
	
	
	public 주인공(){
		요리사_여부();
	}
	
	
	

	public DecimalFormat get숫자_포맷() {
		return 숫자_포맷;
	}
	public 미션보드 get미션보드() {
		return 미션보드;
	}
	public 오픈 get오픈() {
		return 오픈;
	}
	public int get평판() {
		return 평판;
	}
	
	public float show평판() {
		int 평판_준비 =평판/주문수;
		float 평판_소수 = (float)평판_준비/100;
		return 평판_소수;
	}
	

	// 가게 오픈을 할 지 아니면 메뉴개발이나 트레이닝을 할지. 
	// 휴식을 할지. 
	// 메뉴 개발을 통해 매출을 늘려갈 수 도 있고 
	// 실력을 길러서 명성과 가격을 올리거나 할 수 도 있다. 
	public void 인사() {
		시나리오.출력(시나리오.주인공_인사멘트(이름));
	}
	public void 정보체크_시작(주인공 주인공) {
		미션보드.정보체크(주인공);
	}
	public void 영업중(주인공 주인공) {
		오픈.오픈(주인공);
	}
	

	
	/////////정보 출력
	public void 정보보기(주인공 주인공) {
		주인공정보(); 시나리오.돌아가기(주인공);
	}
	public void 오픈에서정보보기(주인공 주인공){
		주인공정보(); 
		시나리오.엔터(); 
		오픈.오픈(주인공);
	}
	
	public void 주인공정보() {
		시나리오.출력(시나리오.선나누기 + "\n\n"+
		"     " + 이름 + " 관련 정보 \n");
		시나리오.출력("현재 평판: "+show평판());	
		시나리오.출력("가진 돈: "+ 숫자_포맷.format(돈) + "만원");
		시나리오.출력("\n보유 아이템 : \n");
		시나리오.같은줄(팬_여부_리턴() ? "     " + 팬.get이름() : "");
		시나리오.같은줄(화구_여부_리턴() ? "     " + 화구.get이름() : "");
		시나리오.출력("\n\n보유직원: \n");
		for(int i=0; i < 보유직원.size(); i++) {
			시나리오.출력((i+1) +". "+ 보유직원.get(i).get이름());}
		시나리오.출력("\n보유 식재료: \n");
		for(int i=0; i < 보유_식재료.size(); i++) {
			시나리오.출력((i+1)+". "+보유_식재료.get(i).get식재료_이름());}
	}
	
	public void 평판계산(int 새_평판) {
		
		평판 = 평판 + 새_평판; 
		주문수 = 주문수 +1;
		if(평판/주문수 >= 499) {
			평판 = 500 * 주문수;
		}
		시나리오.출력("현재 평판: "+ show평판());
	}
	
	
	public void 보유_식재료_출력() {
		String 첫줄 = "보유 중 식재료: ";
		List<String> 보유_식재료_리스트 =
			보유_식재료.stream()
			.map(val -> val.get식재료_이름())
			.collect(Collectors.toList());
		시나리오.리스트_출력(첫줄, 보유_식재료_리스트);}
	
	/////END 정보 출력 

	//Getter Setter 
	public String get이름() 			{return 이름;}
	public void set이름(String 이름)  {this.이름 = 이름;}
	public List<직원> get보유직원() {
		return this.보유직원;
	}
	public List<String> get보유직원리스트() {
		List<String> 보유직원리스트 = new ArrayList<String>();
		for(직원 i: 보유직원) {보유직원리스트.add(i.get직급());}
		return 보유직원리스트;
	}
	public List<식재료> get보유_식재료() {
		return this.보유_식재료;
	}
	public String get특기() {
		String 타입 = 특기;
		return 타입;
	}
	public void set보유_식재료(List<식재료> 보유_식재료) {
		this.보유_식재료 = 보유_식재료;
	}
	public void add보유직원(직원 직원) {
		시나리오.출력(직원.get직급()+" "+시나리오.추가);
		보유직원.add(직원);
	}
	public void add팬(A_팬들 구매한_팬) {
		this.팬 = 구매한_팬; 
	}
	public void add화구(A_화구 구매한_화구) {
		this.화구 = 구매한_화구; 
	}
	public String 팬_여부() {
		return 팬 == null ? 시나리오.없음 : 시나리오.있음;
	}
	public String 화구_여부() {
		return 화구 == null ? 시나리오.없음 : 시나리오.있음;
	}
	public boolean 팬_여부_리턴() {
		return 팬 == null ? false : true; 
	}
	public boolean 화구_여부_리턴() {
		return 화구 == null ? false : true; 
	}
	public boolean 홀직원_여부() {
		boolean 홀직원있음 = false; 
		A_홀직원 홀직원= new A_홀직원();
		for(직원 직원 : 보유직원) {
			if(직원.get직급() == 홀직원.get직급()) {
				홀직원있음 = true;
			}
		 }
		return 홀직원있음; 
	}
	public String 요리사_여부() {
		
		요리사여부 = false;
		String 상대_요리사_체크 = ""; 
		if(보유직원.size() > 0) {
			for(직원 직원 : 보유직원) {
				if(상대집안특기 == 직원.get특기()) {
					상대_요리사_체크 = 직원.get특기();
					요리사여부 = true;
				}
			 }
		}
		
		return 요리사여부 ? 상대_요리사_체크 : "없음"; 
	}
	private boolean 요리사여부업데이트() {
		요리사_여부();
		return 요리사여부; 
		
	}
	public boolean get요리사여부() {
		return 요리사여부;
	}
	public boolean 구매(int 제품가격) {
		if(제품가격 > this.돈) {
			시나리오.출력("자본이 부족합니다!");
			return false;
		}
		this.돈 = this.돈 - 제품가격;
		return true;
	}
	public void set주문수(int 주문수) {
		this.주문수 = 주문수;
	}
	public void add돈(int 돈) {
		this.돈 = this.돈 + 돈; 
	}
	public void add미션_성공수(int 미션성공) {
		this.미션_성공수 = this.미션_성공수 + 미션성공;
	}
	public void add보유_식재료들(List<식재료> 추가_식재료들) {
		this.보유_식재료.addAll(추가_식재료들);
	}
	public void add보유_식재료(식재료 추가_식재료) {
		this.보유_식재료.add(추가_식재료);
	}
	
	
	public int get주문수() {
		return 주문수;
	}
	public A_팬들 get팬() {
		return 팬; 
	}
	public A_화구 get화구() {
		return 화구; 
	}
	public int get돈() {
		return 돈; 
	}
	public int get미션_성공수() {
		return 미션_성공수;
	}
	public void set타임어택완료(boolean 세팅) {
		this.타임어택완료 = 세팅;
	}
	public boolean get타임어택완료() {
		return 타임어택완료;
	}
	public boolean get타임어택실패() {
		return 타임어택실패; 
	}
	public void set타임어택실패(boolean 결과) {
		this.타임어택실패 = 결과;
	}
	public void set평판(int 평판) {
		this.평판 = 평판;
	}
	public String get상대집안특기() {
		return 상대집안특기; 
	}
	public int get미션성공수() {
		return 미션_성공수;
	}
	



	
	
	
	
	
	
	
	
	//Jump to Java (처음에는 한 번 쭉)
	//input 대비 아웃풋
	//비는 부분이 생기지 않게
	//클래스 선언 법// static
	//
	
}
