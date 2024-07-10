package day6;

public class ControlNumber2 {
    public static String solution(int[] numLog) {
        String answer = "";
        for (int i = 0; i < numLog.length-1; i++) {
            if(numLog[i]+1 == numLog[i+1]){
                answer = answer.concat("w");
            } else if (numLog[i]-1 == numLog[i+1]) {
                answer = answer.concat("s");
            }else if (numLog[i]+10 == numLog[i+1]) {
                answer = answer.concat("d");
            }else if (numLog[i]-10 == numLog[i+1]) {
                answer = answer.concat("a");
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1}));
    }
}
