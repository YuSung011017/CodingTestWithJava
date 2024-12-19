package day7;

import java.util.ArrayList;

public class Colatts {
    //모든 자연수 x에 대해서 현재 값이 x이면 x가 짝수일 때는 2로 나누고,
    // x가 홀수일 때는 3 * x + 1로 바꾸는 계산을 계속해서 반복하면 언젠가는 반드시 x가 1이 되는지 묻는 문제를 콜라츠 문제라고 부릅니다.
    public static int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(n);
        while(n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                list.add(n);
            } else if (n % 2 == 1) {
                n = 3 * n + 1;
                list.add(n);
            }
        }
    int [] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int [] arr = solution(10);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
