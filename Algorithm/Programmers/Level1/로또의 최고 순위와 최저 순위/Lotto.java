public class Lotto {
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroNumberCount = 0;
        int sameNumberCount = 0;

        for (int lottoNumbers : lottos) {
            if (lottoNumbers == 0) {
                zeroNumberCount++;
            }
        }
        for (int win_num : win_nums) {
            sameNumberCount += contains(lottos, win_num);
        }
        answer[0] = ranking(sameNumberCount + zeroNumberCount);
        answer[1] = ranking(sameNumberCount);
        return answer;
    }

    private int contains(int[] lottos, int win_num) {
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == win_num)
                return 1;
        }
        return 0;
    }

    private int ranking(int count) {
        int rankingNumber = 7 - count;
        return Math.min(6, rankingNumber);
    }
    
}
