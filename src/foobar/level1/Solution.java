package foobar.level1;

import java.util.*;

// https://foobar.withgoogle.com/
public class Solution {

    public static void main(@SuppressWarnings("CStyleArrayDeclaration") String args[]) {
//        int[] data = new int[]{1, 2, 3};
//        int n = 0;
//        int[] data = new int[]{5, 10, 15, 10, 7};
//        int n = 1;
//        int[] data = new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5};
//        int n = 1;
        int[] data = new int[]{1, 1, 1};
        int n = 2;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int datum : data) {
            int count = map.getOrDefault(datum, 0);
            map.put(datum, count + 1);
        }

        for (int datum : data) {
            if (map.getOrDefault(datum, 0) <= n) {
                result.add(datum);
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
}
