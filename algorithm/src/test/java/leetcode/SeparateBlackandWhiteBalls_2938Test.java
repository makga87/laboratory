package leetcode;

import org.junit.jupiter.api.Test;

class SeparateBlackandWhiteBalls_2938Test {

	@Test
	public void test() {
		//				String s = "0111";
		//				int expected = 0;

		//		String s = "100";
		//		int expected = 2;

		//		String s = "11000111";
		//		int expected = 6;
		//		String s = "11111111110000000000";

		String s = "101";
		int expected = 1;

		exec2(s);
		//		exec1(s);
	}

	private void exec1(String s) {

		int count = 0;

		String temp = new String(s);
		int white = temp.lastIndexOf("0");
		int black = temp.indexOf("1");

		if (white < 0 || black < 0) {
			return;
		}

		while (black < white) {
			char[] chars = temp.toCharArray();
			white = temp.lastIndexOf("0");
			black = temp.indexOf("1");

			if (black < white) {
				chars[white] = '1';
				chars[black] = '0';
				count += white - black;
				temp = String.valueOf(chars);

			} else {
				break;
			}
		}

		System.out.println(temp);
		System.out.println(count);
	}

	private void exec2(String s) {

		long sum = 0;
		int left = s.length() - 1;
		int right = s.length() - 1;

		char[] chars = s.toCharArray();

		while (left >= 0) {

			if (chars[left] == '1' && chars[right] == '0') {
				chars[right] = '1';
				chars[left] = '0';
				sum += right - left;
				right--;
			} else if (chars[right] == '1') {
				right--;
			}
			left--;
		}

		System.out.println(sum);
	}

	private void exec3(String s) {
		long sum = 0;
		long count = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);  // Getting the character at position i
			if (ch == '0') {
				count++;
			} else if (ch == '1') {
				sum += count;
			}
		}
		System.out.println(sum);
	}
}