package inflearn.step2;


/**
 * 인프런 2강
 * 문제2
 * 정수론의 규칙을 찾아야하는데 root를 씌워줘서 횟수를 반으로 줄이는 경우가 제법 있는듯
 * @param args
 */
public class Pow {
	public static void main(String[] args) {
		int N = 15;

		int sqrt = (int) Math.sqrt(15);

		for(int i = 2; i <= sqrt; i++){
			if(N % i == 0){
				System.out.println((i) + " " + (N / i));
			}
		}
	}
}
