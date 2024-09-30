package bruteforce.step2;

/**
 * 최대 공약수 간격을 최소한까지 줄여도 구할 수 있다.
 * <p>
 * 1. 갭을 줄여도 된다.
 * 2. 최대공약수라는 말은 두 수 중 하나로 나눠어서 나머지가 생기지 않는다.
 * 3. 한 수를 가능한 만큼 갭을 줄인다.
 * 하나의 수를 작은수로 되는 만큼 뺀다는 말은
 * 나누고 나서 나머지를 뜻한다.
 */
public class GcdLcm {
	public static void main(String[] args) {
		int A = 30;
		int B = 36;

		GcdLcm gcdLcm = new GcdLcm();
		int aResult = gcdLcm.gcd(A, B);
		int bResult = gcdLcm.lcm(A, B);
		System.out.println(aResult + " " + bResult);
	}


	public int gcd(int A, int B) {

		// 최대공약수를 찾았다는 의미
		while (A % B != 0) {
			int tmp = A % B;
			A = B;
			B = tmp;
		}
		return B;
	}

	public int lcm(int A, int B) {
		return A* B / gcd(A, B);
	}
}


