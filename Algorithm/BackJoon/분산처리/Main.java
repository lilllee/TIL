package BackJoon.분산처리;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int a, b, r;
		for (int i = 0; i < count; i++) {
			r = 1;
			a = scanner.nextInt();
			b = scanner.nextInt();
			if (a % 10 == 0){
				System.out.println(10);
				continue;
			}
			for (int j = 0; j < b; j++){
				r = r * a % 10;
			}
			System.out.println(r);
		}
		scanner.close();
	}
}
