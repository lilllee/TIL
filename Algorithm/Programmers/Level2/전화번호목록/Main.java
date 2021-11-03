import java.util.*;

public class Main {

	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			String substring = phone_book[i + 1].substring(0, phone_book[i].length());
			if (substring.startsWith(phone_book[i])){
				return false;
			}
		}
		return true;
	}
}
