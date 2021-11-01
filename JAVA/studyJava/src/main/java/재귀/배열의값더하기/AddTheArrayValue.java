package 재귀.배열의값더하기;

public class AddTheArrayValue {

    public int sum(int[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return arr[startIdx];
        }
        int middleIdx = (startIdx + endIdx) / 2;
        return sum(arr, startIdx, middleIdx) + sum(arr, middleIdx + 1, endIdx);
    }
}
