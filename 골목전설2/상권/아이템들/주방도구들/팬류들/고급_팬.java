package 상권.아이템들.주방도구들.팬류들;

public class 고급_팬 extends A_팬들{
	
	public 고급_팬(){
		
		이름 = "고급 팬";
		효율성_도움 = 2; 
		가격 = 30;
	}
	@Override
	public String get이름() {
		return 이름;
	}
	@Override
	public int get가격() {
		return 가격;
	}
	

}
