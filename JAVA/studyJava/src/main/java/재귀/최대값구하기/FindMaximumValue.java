package 재귀.최대값구하기;

public class FindMaximumValue {

    public int findMaxValue(int[] array, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return array[startIdx];
        }
        int middleIdx = (startIdx + endIdx) / 2;
        int leftValue = findMaxValue(array, startIdx, middleIdx);
        int rightValue = findMaxValue(array, middleIdx + 1, endIdx);
        return Math.max(leftValue, rightValue);
    }
}