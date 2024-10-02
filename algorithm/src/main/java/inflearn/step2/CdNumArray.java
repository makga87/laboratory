package inflearn.step2;

import java.util.ArrayList;
import java.util.Arrays;

public class CdNumArray {

	public static void main(String[] args) {
		int[] _input = {17, 42, 2184, 2200};
		int[] input = Arrays.copyOf(_input, _input.length+1);

		ArrayList list = new ArrayList();
		int count = 0;

		int currNum = 0;
		int tempNum = 0;

		for (int i = 0; i < input.length-1; i++) {

			currNum = input[i];
			for(int j = currNum; j < input[i+1]; j++) {

				if(gcd(input[i+1], currNum) == 1) {
					continue;
				}

				if(gcd(j, currNum) == 1) {
					if(gcd(input[i+1], currNum) == 1) {
						count++;
						list.add(j);
						currNum = input[i+1];
						break;
					} else {
						currNum = j;
					}
				}
			}
		}
		System.out.println(count);
		System.out.println(list);


	}

	public static int gcd(int a, int b) {

		while(a % b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return b;
	}
}
