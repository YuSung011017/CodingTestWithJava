package day6;

public class LastTwoElement {
    public static int[] solution(int[] num_list) {
        int answer[] = new int[num_list.length+1];
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
       if(num_list[num_list.length-1]>num_list[num_list.length-2])
           answer[num_list.length]=num_list[num_list.length-1] - num_list[num_list.length-2];
       else{
           answer[num_list.length]=num_list[num_list.length-1]*2;
       }
       return answer;
    }
    public static void main(String[] args) {
        int[] num_list = {2,1,6};
        int answer[] = solution(num_list);
        for(int i = 0; i<=num_list.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
