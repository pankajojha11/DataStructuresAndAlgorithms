package com.slidingwindownew;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {

    private static int fruitBasket(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int maxSize = 0;
        Map<Integer, Integer> uniqueCharacters = new HashMap();
        while (j < arr.length) {
            // calculation
            uniqueCharacters.put(arr[j], uniqueCharacters.getOrDefault(arr[j], 0) + 1);
            if (uniqueCharacters.size() < k)
                j++;
            else if (uniqueCharacters.size() == k) {
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else if (uniqueCharacters.size() > k) {
                while (uniqueCharacters.size() > k) {
                    uniqueCharacters.replace(arr[i], uniqueCharacters.get(arr[i]) - 1);
                    if (uniqueCharacters.get(arr[i]) == 0)
                        uniqueCharacters.remove(arr[i]);
                    i++;
                }
                j++;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2};
        int k = 2;
        System.out.println(fruitBasket(arr, k));
    }


}
