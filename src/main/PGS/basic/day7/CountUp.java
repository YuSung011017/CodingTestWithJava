package day7;

import java.util.ArrayList;

public class CountUp {
    public static int[] solution(int start_num, int end_num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = start_num; i <= end_num; i++) {
            list.add(i);
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int []arr = solution(3, 10);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
