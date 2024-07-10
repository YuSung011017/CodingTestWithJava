package monthCodeChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AddTwoPick {
    static public int[] solution(int[] numbers) {
        Set<Integer> list  = new HashSet<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int index = 0;
        while(it.hasNext()) {
            Integer temp = it.next();
            answer[index] = temp;
            index++;
        }
        Arrays.sort(answer);
       return answer;
    }

    public static void main(String[] args) {
        int []arr = solution(new int[]{5,0,2,7});
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
