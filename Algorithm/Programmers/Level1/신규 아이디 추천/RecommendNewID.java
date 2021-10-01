public class RecommendNewID {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^-_.0-9a-z]", "");
        answer = answer.replaceAll("[.]{2}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        if (answer.length() == 0) {
            answer = "a";
        }
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        if (answer.length() <= 2) {
            int idx = answer.length() - 1;
            char c = answer.charAt(idx);
            for (int i = idx; i < 2; i++) {
                answer += c;
            }
        }
        return answer;
    }
    
}