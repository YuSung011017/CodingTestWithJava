package day7;

import java.util.ArrayList;

//변수 i를 만들어 초기값을 0으로 설정한 후 i가 arr의 길이보다 작으면 다음 작업을 반복합니다.
//만약 stk가 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
//stk에 원소가 있고, stk의 마지막 원소가 arr[i]보다 작으면 arr[i]를 stk의 뒤에 추가하고 i에 1을 더합니다.
//stk에 원소가 있는데 stk의 마지막 원소가 arr[i]보다 크거나 같으면 stk의 마지막 원소를 stk에서 제거합니다.
public class MakeList4 {
    public static int[] solution(int[] arr) {
        int i = 0;
        ArrayList<Integer> stk = new ArrayList<Integer>();
        while (i < arr.length) {
            if(stk.isEmpty()){
                stk.add(arr[i]);
                i += 1;
            }else if(stk.get(stk.size()-1) < arr[i]){
                stk.add(arr[i]);
                i += 1;
            }else if(stk.get(stk.size()-1) >= arr[i]){
                stk.remove(stk.size()-1);
            }
        }
        int [] list = new int[stk.size()];
        for(i = 0; i < stk.size(); i++){
            list[i] = stk.get(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int []arr = {1, 4, 2, 5, 3};
        int []answer = solution(arr);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
