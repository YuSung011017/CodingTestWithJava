package day12;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MakeList3 {
    public static int[] solution(int[] arr, int[][] intervals) {
        int answer[] = {};
       for(int i = 0; i<intervals.length; i++){
            int [] temp = Arrays.copyOfRange(arr,intervals[i][0],intervals[i][1]+1);
            answer = IntStream.concat(Arrays.stream(answer), Arrays.stream(temp)).toArray();
       }
       return answer;
    }
    public static void main(String[] args) {
        int [] answer = solution(new int[]{1, 2, 3, 4, 5},new int [][]{{1, 3},{0, 4}});
        for(int i = 0; i< answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
