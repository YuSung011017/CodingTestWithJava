package day9;

import java.util.ArrayList;

public class MakeAList5 {
    public static ArrayList<Integer> solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer>answer = new ArrayList<>();
        for(int i = 0; i< intStrs.length; i++){
            String temp = intStrs[i];
            StringBuilder sb = new StringBuilder();
            for(int j = s; j<s+l; j++){
                sb.append(temp.charAt(j));
            }
            int a = Integer.parseInt(sb.toString());
            if(a>k && a < Math.pow(10,l) ){
                answer.add(a);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String str[] = {"0123456789","9876543210","9999999999999"};
        ArrayList<Integer> list = solution(str,50000,5,5);
        for(int i = 0; i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
