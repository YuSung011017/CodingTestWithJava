package day11;

import java.util.ArrayList;

public class MakeList1 {
    public static ArrayList<Integer> solution(int n, int k) {
        ArrayList<Integer>answer = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(i % k == 0)
                answer.add(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        ArrayList<Integer>answer = solution(10,3);
        for(int i : answer)
            System.out.print(i + " ");
    }
}
