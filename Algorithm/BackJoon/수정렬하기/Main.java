package 수정렬하기;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		int[] nums;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scan.nextInt();
		}
		Arrays.sort(nums);
		for (int num : nums) {
			System.out.println(num);
		}
		scan.close();
	}
}
