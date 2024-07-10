package day7;

import java.util.ArrayList;

public class makeList2 {
    static int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<Integer>();
       for(int i = l; i <= r; i++) {
           String str = Integer.toString(i);
           boolean check[] = new boolean[str.length()];
           int checkCount = 0;
           for(int j = 0; j < str.length(); j++) {
               if(str.charAt(j) == '5' || str.charAt(j) == '0') {
                   check[j] = true;
               }
           }
           for(int j = 0; j < check.length; j++) {
               if(check[j]) {
                   checkCount++;
               }
           }
           if(checkCount == str.length()) {
               int temp = Integer.parseInt(str);
               list.add(temp);
           }
       }
       int arr[];
       if(list.size() == 0) {
            arr = new int[]{-1};
       }
       else {
           arr = new int[list.size()];
           for (int i = 0; i < arr.length; i++) {
               arr[i] = list.get(i);
           }
       }
       return arr;
    }

    public static void main(String[] args) {
        int arr [] = solution(10,20);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
