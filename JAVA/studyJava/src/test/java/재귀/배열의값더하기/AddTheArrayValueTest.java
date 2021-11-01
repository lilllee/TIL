package 재귀.배열의값더하기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AddTheArrayValueTest {


    AddTheArrayValue addTheArrayValue = new AddTheArrayValue();
    List<int[]> arrays = new ArrayList<int[]>();

    @BeforeEach
    void setup() {
        int[] array = new int[]{4, 2, 5, 1, 5, 3, 1, 2};
        int[] array1 = new int[]{2, 5, 7, 8, 3, 1, 2, 3, 5, 12, 5, 7};
        int[] array2 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        arrays.add(array);
        arrays.add(array1);
        arrays.add(array2);
    }

    @Test
    @DisplayName("배열 값 더하는 테스트")
    public void name() throws Exception {
        List<Integer> sumArrays = new ArrayList<>();
        for (int[] values : arrays) {
            sumArrays.add(addTheArrayValue.sum(values,0,values.length - 1));
        }

        Assertions.assertEquals(sumArrays, List.of(23, 60, 10));

    }
}