package 상권.아이템들.주방도구들;

import 상권.아이템들.아이템;

public class 주방도구 extends 아이템{
	
	protected String 이름; 
	protected int 효율성_도움;
	protected int 가격;
	
	public int get효율성_도움() {
		return 효율성_도움;
	}
	public String get이름() {
		return 이름;
	}
	public int get가격() {
		return 가격;
	}
}
