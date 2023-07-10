package 미션들;

import A_시나리오.시나리오;
import 미션들.일반미션들.미션A;
import 미션들.일반미션들.미션B;
import 미션들.일반미션들.미션C;
import 미션들.일반미션들.미션D;
import 캐릭터들.집안.주인공;

public class 미션보드_일반 {
	
	public 미션A 미션A;
	public 미션B 미션B;
	public 미션C 미션C;
	미션D 미션D;
	
	미션보드_일반(){
		미션A = new 미션A();
		미션B = new 미션B();
		미션C = new 미션C();
		미션D = new 미션D();
	}
	public 미션 일반_미션_선택(주인공 주인공) {
		
		try {
			switch(일반_미션_선택_시나리오()) {
				case 1:	return new 미션A();
				case 2:	return 미션A.get성공여부() ? new 미션B() : new 미션B();
				case 3:	return 미션B.get성공여부() ? new 미션C() : new 미션C(); 
				case 4:	return 미션C.get성공여부() ? 미션D : 미션D;
				case 5: 주인공.미션보드.미션_선택(주인공); break;
			}
			return null;
		}catch(Exception E){
	
			
			return null;
			
		}
	}
	private int 일반_미션_선택_시나리오() {
		
		시나리오.첫줄("기본 미션을 선택해 주세요.\n");
			시나리오.출력("1.일반 미션 1: "+ 미션A.미션내용);
			시나리오.출력("2.일반 미션 2: "+ 미션B.미션내용);
			시나리오.출력("3.일반 미션 3: "+ 미션C.미션내용);
			시나리오.출력("4 일반 미션 4: "+ 미션D.미션내용);
			시나리오.출력("5 돌아가기");
			시나리오.한줄("선택: ");
			return 시나리오.선택();
	
	}
}
