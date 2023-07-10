package 캐릭터들.집안;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class 집안Test {

	@Test
	void test() {
		주인공 주인공 = new 주인공();
		주인공.set평판(450);
		
		for(int i = 0; i< 49; i++) {
			주인공.평판계산(500);
		}

		assertEquals(주인공.get주문수(), 50);
	}

}
