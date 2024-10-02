package inflearn.step2;

public class HiddenNumber {

	/**
	 * 인프런 2강
	 * 문제3
	 * 문제가 잘 못된 부분
	 * 2의 제곱이면서 최대 약수의 합
	 * 팩토리얼로 푸는 문제
	 *
	 * 해당 문제의 정수론 킥!
	 * 임의의 정수 N에 2의 제곱으로 나눌 수 있는 수가 몇번일지 계산하려면
	 * 임의의 값을 2로 계속 나눠서 더이상 나눌수 없을 때까지 나눠본다. 이 때, 소숫점은 날리고 정수부분만 취합해서
	 * 모두 나온 값을 더하면 동일한 값이 나온다.
	 * 2가 아닌 3으로 해도 나온다.
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		A의 팩토리얼과, B의 팩토리얼을 구해서 서로 빼면 답이 나온다
		 */


		/*
		         1 2 3 4 5 6 7 8
			2*0  o o o o o o o o -> 8개 (8 / 1)
			2*1    o   o   o   o -> 4개 (8 / 2)
			2*2        o       o -> 2개 (8 / 4)
			2*3                o -> 1개 (8 / 8)
		 */
		int A = 175;
		int B = 177;

		int tmpA = A;
		for(int i = 1; i < 99; i++) {
			tmpA+= (int) ((A / (int)Math.pow(2,i)) * ((int)Math.pow(2,i) - Math.pow(2, (i - 1))));
		}

		int tmpB = B;
		for(int i = 1; i < 99; i++) {
			tmpB += (int) ((B / (int)Math.pow(2,i)) * ((int)Math.pow(2,i) - Math.pow(2, (i - 1))));
		}

		System.out.println(tmpB - tmpA);
	}
}
