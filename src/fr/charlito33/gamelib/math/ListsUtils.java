package fr.charlito33.gamelib.math;

import java.util.Arrays;
import java.util.List;

public class ListsUtils {
    public static int[] toArrayInt(List<Integer> list) {
        int[] result = new int[list.size()];
        int i = 0;


        for (int j : list) {
            result[i] = j;
            i++;
        }

        return result;
    }
}
