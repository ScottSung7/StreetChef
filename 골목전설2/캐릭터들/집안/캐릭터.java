package 캐릭터들.집안;

import A_시나리오.시나리오;
import 캐릭터들.집안.중식대가집안.중식대가;
import 캐릭터들.집안.중식대가집안.캐릭터_영준;
import 캐릭터들.집안.한식대가집안.캐릭터_윤수;

public class 캐릭터 {
	protected int 캐릭터번호; 
	public 주인공 캐릭터선택(주인공 주인공) {
		시나리오.출력("캐릭터를 선택해 주세요.\n\n"
				+ "1.한식대가 윤수 		 2. 중식대가 영준");
		시나리오.한줄("\n선택한 캐릭터: ");
		int 캐릭터 = 시나리오.선택();
		switch(캐릭터) {
			case 1: 주인공 = new 캐릭터_윤수(); break;
			case 2: 주인공 = new 캐릭터_영준(); break;}
		return 주인공;}
	
	public void 캐릭터조회(주인공 주인공) {
		switch(캐릭터번호) {
			case 1: 윤수 = (캐릭터_윤수)주인공; 윤수.hi(); break;
			case 2: 영준 = (캐릭터_영준)주인공; 영준.gogo(); break;}
		 }

	
	캐릭터_영준 영준;	캐릭터_윤수 윤수;
	public void 특기() {
		switch(캐릭터번호) {
		case 1: 윤수.hi(); break;
		case 2: 영준.hi(); break;}}
	
}
