package hash;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class HashTest {

	@Test
	void HashMap은_중복된_데이터는_해시충돌회피를_통해_저장한다() {
		HashMap hashMap = new HashMap<Object, Object>();
		hashMap.put(new A().hashCode(), "A");
		hashMap.put(new B().hashCode(), "B");
		hashMap.put(new C().hashCode(), "C");

		System.out.println(hashMap);
	}


	private class A {
		public String value = "A";

		@Override
		public int hashCode() {
			return 110;
		}
	}

	private class B {
		public String value = "B";

		@Override
		public int hashCode() {
			return 112;
		}
	}

	private class C {
		public String value = "C";

		@Override
		public int hashCode() {
			return 110;
		}
	}
}