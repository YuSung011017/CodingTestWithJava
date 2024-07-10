package day8;

import java.util.Arrays;

public class Dice3 {
    //네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
    //세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
    //주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
    //어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
    //네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
    public static int solution(int a, int b, int c, int d) {
        int arr[] = {a,b,c,d};
        Arrays.sort(arr);
        int answer= 0;
        if(arr[0] == arr[3]){ //모두 같은
            answer= 1111*a;
        }else if(arr[0]==arr[2] || arr[1]==arr[3]) { // 세 주사위가 같은
            int p = arr[0] == arr[1] ? arr[0] : arr[3];
            int q = arr[0] == arr[1] ? arr[3] : arr[0];
            answer = (int) Math.pow((10 * p + q), 2);
        }else if(arr[0]==arr[1] && arr[2]==arr[3]){ //각각 두개의 값이 같은
            answer = (arr[0] + arr[3]) * (arr[3]-arr[0]);
        }else if(arr[0] == arr[1]){
            answer = arr[2] * arr[3];
        } else if (arr[1] == arr[2]) {
            answer = arr[0] * arr[3];
        } else if (arr[2] == arr[3]) {
            answer = arr[0] * arr[1];
        } else {
            answer = arr[0];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(6,3,3,6));

    }
}
