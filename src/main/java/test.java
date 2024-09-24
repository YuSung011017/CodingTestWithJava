import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 두 문자열 입력 받기
        String a = sc.nextLine();
        String b = sc.nextLine();

        // 문자열을 문자 배열로 변환
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        // DP 테이블 초기화
        int[][] dp = new int[aArr.length + 1][bArr.length + 1];

        // DP 테이블 채우기
        for (int i = 1; i <= aArr.length; i++) {
            for (int j = 1; j <= bArr.length; j++) {
                if (aArr[i - 1] == bArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 최종 결과 출력
        System.out.println(dp[aArr.length][bArr.length]);

        sc.close();
    }
}
