
public class CountDown {
    public static int[] solution(int start_num, int end_num) {
        int answer [] = new int [start_num - end_num +1];
       for(int i = 0; i<=start_num-end_num; i++){
           answer[i] = start_num-i;
       }
        return answer;
    }
    public static void main(String[] args) {
        int temp [] = solution(10,3);
        for(int i = 0; i< temp.length; i++){
            System.out.print(temp[i] + " ");
        }
    }
}
