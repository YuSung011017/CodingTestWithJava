package day12;

import java.util.ArrayList;
import java.util.Arrays;

//n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
//n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
//n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
//n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
public class ListSlice {
    public static int[] solution(int n, int[] slicer, int[] num_list) {
        int []answer = {};
       switch (n){
           case 1:
               answer = Arrays.copyOfRange(num_list,0,slicer[1]+1);
               break;
           case 2:
               answer = Arrays.copyOfRange(num_list,slicer[0],num_list.length);
               break;
           case 3:
               answer = Arrays.copyOfRange(num_list,slicer[0],slicer[1]+1);
               break;
           case 4:
               ArrayList<Integer>arrayList = new ArrayList<>();
              for(int i = slicer[0];i<=slicer[1];i += 2){
                  arrayList.add(num_list[i]);
              }
              answer = arrayList.stream().mapToInt(Integer::intValue).toArray();
              break;
       }
       return answer;
    }
    public static void main(String[] args) {
        int [] answer = solution(3,new int []{1,5,2},new int []{1, 2, 3, 4, 5, 6, 7, 8, 9});
        for(int i = 0; i< answer.length;i++){
            System.out.print(answer[i] + " ");
        }
    }
}
