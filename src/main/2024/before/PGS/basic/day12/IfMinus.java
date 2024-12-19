package day12;

public class IfMinus {
    public static int solution(int[] num_list) {
        for(int i = 0; i< num_list.length; i++){
            if(num_list[i]<0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int []{12, 4, 15, 46, 38, -2, 15}));
    }
}
