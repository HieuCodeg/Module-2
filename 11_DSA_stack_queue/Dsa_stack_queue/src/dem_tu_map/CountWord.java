package dem_tu_map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {

        System.out.println("Nhập vào chuỗi: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.toUpperCase().split(" ");
        Map<String,Integer> dictionary = new TreeMap<String,Integer>();
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (dictionary.containsKey(temp)) {
                int value = dictionary.get(temp);
                value++;
                dictionary.put(temp,value);
            } else {
                dictionary.put(temp,1);
            }
        }
        System.out.println(dictionary);
    }
}
