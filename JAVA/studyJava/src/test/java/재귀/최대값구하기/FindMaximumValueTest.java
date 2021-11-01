package 재귀.최대값구하기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FindMaximumValueTest {


    FindMaximumValue findMaximumValue = new FindMaximumValue();
    List<int[]> arrays = new ArrayList<int[]>();

    @BeforeEach
    void setUp() {
        int[] array = {1, 2, 5, 7, 7, 2, 34, 2};
        int[] array1 = {64, 123, 156261, 123152, 885};
        int[] array2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] array3 = {0, 0, 1, 0, 0, 1, 0, 0, 0};
        arrays.add(array);
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);
    }

    @Test
    @DisplayName("최대값 찾기")
    public void findMaxValue() throws Exception {
        //given
        List<Integer> maxValueArrays = new ArrayList<>();
        //when
        for (int[] values : arrays) {
            maxValueArrays.add(findMaximumValue.findMaxValue(values, 0, values.length - 1));
        }
        //then
        Assertions.assertEquals(maxValueArrays, List.of(34, 156261, 0, 1));
    }

}